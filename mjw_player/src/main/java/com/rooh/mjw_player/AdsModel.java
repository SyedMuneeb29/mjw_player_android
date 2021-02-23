package com.rooh.mjw_player;

import java.io.Serializable;

public class AdsModel implements Serializable {

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