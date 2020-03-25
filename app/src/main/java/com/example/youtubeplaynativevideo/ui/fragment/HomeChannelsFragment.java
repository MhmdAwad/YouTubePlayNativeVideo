package com.example.youtubeplaynativevideo.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.youtubeplaynativevideo.R;
import com.example.youtubeplaynativevideo.pojo.ChannelData;
import com.example.youtubeplaynativevideo.ui.adapter.ChannelsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeChannelsFragment extends Fragment {

    public HomeChannelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_home_channels, container, false);

        RecyclerView channelsRV = rootView.findViewById(R.id.homeChannelsRV);
        channelsRV.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        List<ChannelData> channelData = new ArrayList<>();
        channelData.add(new ChannelData("zAmericanEnglish","UCHrD4qdeQc1BbpG6EPqDBcA", "https://yt3.ggpht.com/a/AATXAJz4CrvtHFdoHCCizcwBqdYcsAKcVa2Isav6tQ=s288-c-k-c0xffffffff-no-rj-mo"));
        channelData.add(new ChannelData("CodingWithMitch","UCoNZZLhPuuRteu02rh7bzsw", "https://yt3.ggpht.com/a/AATXAJzeVaKgaaldp7IpjgXSWImHTNV9kDqkrCJrMQ=s288-c-k-c0xffffffff-no-rj-mo"));
        channelData.add(new ChannelData("Android Developers","UCVHFbqXqoYvEWM1Ddxl0QDg", "https://yt3.ggpht.com/a/AATXAJz-xXlS2ao5fm1K97AbykChh3X6jnltOvyBBQ=s288-c-k-c0xffffffff-no-rj-mo"));
        channelData.add(new ChannelData("Coding in Flow","UC_Fh8kvtkVPkeihBs42jGcA", "https://yt3.ggpht.com/a/AATXAJyfJAXXqdLLM-XjzTbCTOB3d-z7Q00VOMCyqg=s288-c-k-c0xffffffff-no-rj-mo"));
        channelData.add(new ChannelData("Ali Muhammad Ali","UChbuH4HULlesX_rzlozkT6Q", "https://yt3.ggpht.com/a/AATXAJwWQxCnuqU6TwYotgoN4Q14w4k_TOp7DwMzpA=s288-c-k-c0xffffffff-no-rj-mo"));
        channelData.add(new ChannelData("Arabic Competitive Programming","UC8OxKsmAyrGAfBiluhpLkbA", "https://yt3.ggpht.com/a/AATXAJy2TYYT015eco1-yuuQ6h6AQ-F65562fA2DGg=s288-c-k-c0xffffffff-no-rj-mo"));
        ChannelsAdapter adapter = new ChannelsAdapter(channelData);
        channelsRV.setAdapter(adapter);

        adapter.setOnItemClick((view, pos) -> {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameContainer, new ChannelVideosFragment(channelData.get(pos).getChannelID()))
                    .addToBackStack(null)
                    .commit();
        });
        return rootView;
    }
}
