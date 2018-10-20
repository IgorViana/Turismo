package com.example.igor.teste;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFragment extends Fragment implements ListClickListener {
    RestaurantAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant, container, false);

        List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(getResources().getString(R.string.restaurante1), getResources().getString(R.string.endereco1), getResources().getString(R.string.uri1)));
        placeList.add(new Place(getResources().getString(R.string.restaurante2), getResources().getString(R.string.endereco2), getResources().getString(R.string.uri2)));
        placeList.add(new Place(getResources().getString(R.string.restaurante3), getResources().getString(R.string.endereco3), getResources().getString(R.string.uri3)));
        placeList.add(new Place(getResources().getString(R.string.restaurante4), getResources().getString(R.string.endereco4), getResources().getString(R.string.uri4)));
        placeList.add(new Place(getResources().getString(R.string.restaurante5), getResources().getString(R.string.endereco5), getResources().getString(R.string.uri5)));
        placeList.add(new Place(getResources().getString(R.string.restaurante6), getResources().getString(R.string.endereco6), getResources().getString(R.string.uri6)));
        placeList.add(new Place(getResources().getString(R.string.restaurante7), getResources().getString(R.string.endereco7), getResources().getString(R.string.uri7)));
        placeList.add(new Place(getResources().getString(R.string.restaurante8), getResources().getString(R.string.endereco8), getResources().getString(R.string.uri8)));
        placeList.add(new Place(getResources().getString(R.string.restaurante9), getResources().getString(R.string.endereco9), getResources().getString(R.string.uri9)));
        placeList.add(new Place(getResources().getString(R.string.restaurante10), getResources().getString(R.string.endereco10), getResources().getString(R.string.uri10)));


        RecyclerView recyclerView = rootView.findViewById(R.id.rvRestaurant);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        adapter = new RestaurantAdapter(rootView.getContext(), placeList, this);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onItemSelected(Place place) {

        Uri gmmIntentUri = Uri.parse(place.getPlaceUri());
        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);
        }
    }

}
