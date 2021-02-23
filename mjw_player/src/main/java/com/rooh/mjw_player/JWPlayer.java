package com.rooh.mjw_player;



import android.content.Context;

import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.configuration.PlayerConfig;
import com.longtailvideo.jwplayer.configuration.SkinConfig;
import com.longtailvideo.jwplayer.media.ads.AdBreak;
import com.longtailvideo.jwplayer.media.ads.AdSource;
import com.longtailvideo.jwplayer.media.ads.Advertising;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JWPlayer {

    ArrayList<AdsModel> adList;

    Advertising advertising;

    SkinConfig skinConfig;

    List<PlaylistItem> playlist;

    JWPlayerView mPlayerView;

    Context context;

    //initialize constructor
    public JWPlayer(Context context) {
        this.context = context;
    }


    // setup ads
    public void setAdsSchedule(ArrayList<AdsModel> adList) {

        this.adList = new ArrayList<AdsModel>();


        this.adList = adList;

        List<AdBreak> adSchedule = new ArrayList<>();

        for (int i = 0; i < adList.size(); i++) {

            AdsModel currentAd = adList.get(i);

            AdBreak adBreak = new AdBreak.Builder()
                    .tag(currentAd.getAdTag())
                    .offset(currentAd.getOffSet())
                    .build();

            adSchedule.add(adBreak);

        }

        advertising = new Advertising(AdSource.VAST, adSchedule);


    }


    // setup skin name and path
    public void setSkin(String themeName, String themePath) {

        skinConfig = new SkinConfig.Builder()
                .name(themeName)
                .url(themePath)
                .build();

    }


    // setup playlist
    public void setPlayList(ArrayList<String> songList) {

        playlist = new ArrayList<>();

        for (int i = 0; i < songList.size(); i++) {

            PlaylistItem playlistItem = new PlaylistItem.Builder()
                    .file(songList.get(i))
                    .build();

            playlist.add(playlistItem);

        }

    }


    // setup Player config
    public void setPlayer(JWPlayerView mPlayerView){

        this.mPlayerView = mPlayerView;

        PlayerConfig config = new PlayerConfig.Builder()
                .playlist(playlist)
                .advertising(advertising)
                .skinConfig(skinConfig)
                .build();


        this.mPlayerView.setup(config);

    }

    // Player Start
    public void startPlayer(){
        mPlayerView.play();
    }

    // Player pause
    public void pausePlayer(){
        mPlayerView.onPause();
    }

    // Player resume
    public void resumePlayer(){
        mPlayerView.onResume();
    }

    // Player stop
    public void stopPlayer(){
        mPlayerView.onStop();
    }

    // Player destroy
    public void destroyPlayer(){
        mPlayerView.onDestroy();
    }


    //Model for ads
    /*
    public static class AdsModel implements Serializable {
        String offSet;
        String adTag;
        public AdsModel() {
        }
        public AdsModel(String offSet, String adTag) {
            this.offSet = offSet;
            this.adTag = adTag;
        }
        public String getOffSet() {
            return offSet;
        }
        public void setOffSet(String offSet) {
            this.offSet = offSet;
        }
        public String getAdTag() {
            return adTag;
        }
        public void setAdTag(String adTag) {
            this.adTag = adTag;
        }
    }
    */


}