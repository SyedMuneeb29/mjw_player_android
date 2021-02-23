package com.rooh.mjw_player;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.longtailvideo.jwplayer.JWPlayerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    JWPlayerView jwPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jwPlayerView = findViewById(R.id.jwplayer);
        setup(jwPlayerView);

    }


    void setup (
            JWPlayerView jwPlayerView
    ) {
        JWPlayer jwPlayer = new JWPlayer(this);


        ArrayList<AdsModel> adList;
        adList = new ArrayList<AdsModel>();
        adList.add(new AdsModel("pre", "https://pubads.g.doubleclick.net/gampad/ads?iu=/21792359936/Masthead-VIdeo-for-iOS&description_url=%5bplaceholder%5d&tfcd=0&npa=0&sz=640x480&gdfp_req=1&output=vast&unviewed_position_start=1&env=vp&impl=s&correlator="));
        adList.add(new AdsModel("00:00:15:000", "https://pubads.g.doubleclick.net/gampad/ads?iu=/21792359936/12365432&description_url=[placeholder]&tfcd=0&npa=0&sz=640x480&gdfp_req=1&output=vast&unviewed_position_start=1&env=vp&impl=s&correlator="));
        adList.add(new AdsModel("25%", "https://pubads.g.doubleclick.net/gampad/ads?iu=/21792359936/Masthead-VIdeo-for-iOS&description_url=%5bplaceholder%5d&tfcd=0&npa=0&sz=640x480&gdfp_req=1&output=vast&unviewed_position_start=1&env=vp&impl=s&correlator="));
        jwPlayer.setAdsSchedule(adList);

        jwPlayer.setSkin("alaska", "file:///android_asset/alaska.css");

        ArrayList<String> songs = new ArrayList<>();
        songs.add("https://multiplatform-f.akamaihd.net/i/multi/will/bunny/big_buck_bunny_,640x360_400,640x360_700,640x360_1000,950x540_1500,.f4v.csmil/master.m3u8");
        songs.add("http://demo.unified-streaming.com/video/tears-of-steel/tears-of-steel.ism/.m3u8");
        songs.add("https://multiplatform-f.akamaihd.net/i/multi/april11/sintel/sintel-hd_,512x288_450_b,640x360_700_b,768x432_1000_b,1024x576_1400_m,.mp4.csmil/master.m3u8");
        jwPlayer.setPlayList(songs);

        jwPlayer.setPlayer(jwPlayerView);

        jwPlayer.startPlayer();

    }

    @Override
    protected void onStart() {
        super.onStart();
        jwPlayerView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        jwPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        jwPlayerView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        jwPlayerView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        jwPlayerView.onDestroy();
    }


    public void Close(View view) {
        finish();
    }



}