package com.example.youtubeplaynativevideo.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.youtubeplaynativevideo.R;
import com.example.youtubeplaynativevideo.ui.MainViewModel;
import com.example.youtubeplaynativevideo.ui.adapter.ChannelVideosAdapter;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelVideosFragment extends Fragment {

    private static final String API_KEY = "AIzaSyDVrzh7XFVVNmPAfMGcDDVIOyD_8hFAY48";
    private String channelID;
    private MainViewModel mainViewModel;
    private YouTubePlayer YPlayer;
    private boolean firstCall = true;
    private int maxResult;

    public ChannelVideosFragment(String channelID) {
        this.channelID = channelID;
    }

    public ChannelVideosFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_channel_videos, container, false);

        RecyclerView videosRV = rootView.findViewById(R.id.channelVideosRV);
        ChannelVideosAdapter adapter = new ChannelVideosAdapter();
        videosRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        videosRV.setAdapter(adapter);

        maxResult = 20;
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.getChannelVideos(channelID, maxResult, API_KEY);

        mainViewModel.youTubeVideosMutableLiveData.observe(getActivity(), youTubeVideos -> {

            adapter.addItems(youTubeVideos.getItems());

            videosRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (!videosRV.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                        maxResult += 10;
                        mainViewModel.getChannelVideos(channelID, maxResult, API_KEY);
                        adapter.addItems(youTubeVideos.getItems());
                        firstCall = false;
                    }
                }
            });

            adapter.onVideoClick((view, pos) -> {
                playSingleVideo(youTubeVideos.getItems().get(pos).getId().getVideoId());

            });

            if (firstCall) playSingleVideo(youTubeVideos.getItems().get(0).getId().getVideoId());
        });

        return rootView;
    }

    private void playSingleVideo(String videoLink) {
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.youTubePlayerView, youTubePlayerFragment).commit();

        YouTubePlayer.OnInitializedListener onInitializedListener = new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider arg0, YouTubePlayer youTubePlayer, boolean b) {
                YPlayer = youTubePlayer;
                YPlayer.loadVideo(videoLink);
                YPlayer.play();

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {

            }
        };
        youTubePlayerFragment.initialize(API_KEY, onInitializedListener);
    }

}
