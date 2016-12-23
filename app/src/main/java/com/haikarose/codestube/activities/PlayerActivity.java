package com.haikarose.codestube.activities;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.haikarose.codestube.R;

public class PlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    public static final String apiKey="AIzaSyAw3aNdtOIHH-MX2D-WF9ZGpb6Lr_aU34A";
    public static final String id="0kvf-L2fero";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        YouTubePlayerView playerView=(YouTubePlayerView)findViewById(R.id.player_view);
        playerView.initialize(apiKey,this);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo(id);//loadVideo(id);
        }
    }


}
