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

public class CityFragment extends Fragment {
    RestaurantAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_city, container, false);

        String[] cityNameString = {"Vacouver", "Toronto"};
        String[] cityPopulationString = {"647.540", "2.731.571"};

        RecyclerView recyclerView = rootView.findViewById(R.id.rvCity);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));


        adapter = new RestaurantAdapter(rootView.getContext(),cityNameString, cityPopulationString);
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }

}
