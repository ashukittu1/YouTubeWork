package com.ashutech.youtubework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class SecondActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public YouTubePlayerView youTubePlayerView;
   // public YouTubePlayer.OnInitializedListener onInitializedListener;
    Intent in = getIntent();
    Bundle bb = in.getExtras();
    String st = bb.getString("url");
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube);
   }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo("st");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        }
}



