package com.example.igor.teste;

public class State {
    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private String mStateName;

    public State(int mImageResourceId, String mCountryName){
        this.mImageResourceId = mImageResourceId;
        this.mStateName = mCountryName;
    }


    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getmStateName(){
        return mStateName;
    }

}
