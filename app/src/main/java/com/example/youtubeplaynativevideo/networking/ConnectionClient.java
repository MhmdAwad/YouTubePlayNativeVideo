package com.example.youtubeplaynativevideo.networking;

import com.example.youtubeplaynativevideo.pojo.YouTubeVideos;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionClient {

    private ConnectionInterface connectionInterface;
    private static ConnectionClient instance;
    private String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    private ConnectionClient(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        connectionInterface = retrofit.create(ConnectionInterface.class);
    }

    public static ConnectionClient getInstance(){
        if(instance == null){
            instance = new ConnectionClient();
        }
        return instance;
    }

    public Call<YouTubeVideos> getChannelVideosCall(String channelId, int maxResult, String key){
        return connectionInterface.getChannelVideos("AIzaSyDVrzh7XFVVNmPAfMGcDDVIOyD_8hFAY48",channelId
                ,"snippet,id","date",maxResult);

    }
}
