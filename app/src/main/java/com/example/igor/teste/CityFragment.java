package com.example.igor.teste;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CityFragment extends Fragment {
    RestaurantAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_city, container, false);

        List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(getResources().getString(R.string.cidade1), getResources().getString(R.string.habitantes1)));
        placeList.add(new Place(getResources().getString(R.string.cidade2), getResources().getString(R.string.habitantes2)));
        placeList.add(new Place(getResources().getString(R.string.cidade3), getResources().getString(R.string.habitantes3)));
        placeList.add(new Place(getResources().getString(R.string.cidade4), getResources().getString(R.string.habitantes4)));
        placeList.add(new Place(getResources().getString(R.string.cidade5), getResources().getString(R.string.habitantes5)));
        placeList.add(new Place(getResources().getString(R.string.cidade6), getResources().getString(R.string.habitantes6)));

        RecyclerView recyclerView = rootView.findViewById(R.id.rvCity);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));


        adapter = new RestaurantAdapter(rootView.getContext(), placeList);
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }

}
