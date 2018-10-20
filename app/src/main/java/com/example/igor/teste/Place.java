package com.example.igor.teste;

import android.net.Uri;

public class Place {
    private String placeName;
    private String placeLocation;
    private String placeUri;

    public Place(String placeName, String placeLocation, String placeUri){
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placeUri = placeUri;
    }

    public Place(String placeName, String placeLocation){
        this.placeName = placeName;
        this.placeLocation = placeLocation;
    }


    public String getPlaceLocation() {
        return placeLocation;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceUri() {
        return placeUri;
    }
}
