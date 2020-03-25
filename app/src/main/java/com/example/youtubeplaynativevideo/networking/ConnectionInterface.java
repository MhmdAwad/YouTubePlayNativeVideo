package com.example.youtubeplaynativevideo.networking;

import com.example.youtubeplaynativevideo.pojo.YouTubeVideos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConnectionInterface {

//    @GET("search")
//    Call<YouTubeVideos> getChannelVideos(@Query("part") String part, @Query("channelId") String channelId
//            , @Query("maxResults") int maxResults, @Query("key") String key);

    @GET("search")
    Call<YouTubeVideos> getChannelVideos(@Query("key") String key,@Query("channelId") String channelId, @Query("part") String part,
            @Query("order") String order, @Query("maxResults") int maxResults);

}
