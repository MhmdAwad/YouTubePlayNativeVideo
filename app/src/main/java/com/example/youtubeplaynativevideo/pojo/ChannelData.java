package com.example.youtubeplaynativevideo.pojo;

public class ChannelData {

    private String channelName;
    private String channelID;
    private String channelIcon;

    public ChannelData(String channelName, String channelID, String channelIcon) {
        this.channelName = channelName;
        this.channelID = channelID;
        this.channelIcon = channelIcon;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getChannelID() {
        return channelID;
    }

    public String getChannelIcon() {
        return channelIcon;
    }
}
