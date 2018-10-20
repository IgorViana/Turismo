package com.example.igor.teste;

import com.google.android.gms.maps.model.LatLng;

public class State {
    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private String mStateName;

    private LatLng mLagLng;

    public State(int mImageResourceId, String mCountryName, LatLng mLagLng){
        this.mImageResourceId = mImageResourceId;
        this.mStateName = mCountryName;
        this.mLagLng = mLagLng;
    }

    public State(int mImageResourceId, String mCountryName){
        this.mImageResourceId = mImageResourceId;
        this.mStateName = mCountryName;
        this.mLagLng = null;
    }


    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getmStateName(){
        return mStateName;
    }

    public LatLng getmLagLng() {
        return mLagLng;
    }
}
