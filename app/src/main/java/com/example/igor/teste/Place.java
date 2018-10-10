package com.example.igor.teste;

public class Place {
    private String placeName;
    private String placeLocation;

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
}
