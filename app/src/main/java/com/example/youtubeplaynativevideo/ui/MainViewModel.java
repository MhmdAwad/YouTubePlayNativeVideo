package com.example.youtubeplaynativevideo.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youtubeplaynativevideo.networking.ConnectionClient;
import com.example.youtubeplaynativevideo.pojo.YouTubeVideos;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    public MutableLiveData<YouTubeVideos> youTubeVideosMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<YouTubeVideos> newYouTubeVideosMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> error = new MutableLiveData<>();

    public void getChannelVideos(String channelId, int maxResult, String key){
        ConnectionClient.getInstance().getChannelVideosCall(channelId, maxResult, key).enqueue(new Callback<YouTubeVideos>() {
            @Override
            public void onResponse(Call<YouTubeVideos> call, Response<YouTubeVideos> response) {

                if(response.isSuccessful()){
                    youTubeVideosMutableLiveData.setValue(response.body());
                }else
                    error.setValue("Check Internet and try again");
            }

            @Override
            public void onFailure(Call<YouTubeVideos> call, Throwable t) {
                error.setValue("Check Internet and try again");
            }
        });
    }
}
