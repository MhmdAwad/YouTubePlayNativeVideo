package com.example.youtubeplaynativevideo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.youtubeplaynativevideo.R;
import com.example.youtubeplaynativevideo.ui.fragment.HomeChannelsFragment;
import com.google.android.youtube.player.YouTubeBaseActivity;

public class MainActivity extends AppCompatActivity {

    String api = "AIzaSyB43vfEpUD3NFH5ZV3l1UXcJOZ5aZ7SIZQ";
    String  myAPI = "AIzaSyDVrzh7XFVVNmPAfMGcDDVIOyD_8hFAY48";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new HomeChannelsFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() != 0) {
            getFragmentManager().popBackStack();
        }else
        super.onBackPressed();
    }
}
