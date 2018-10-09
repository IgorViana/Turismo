package com.example.igor.teste;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class CountryFragment extends Fragment {

    CountryAdapter adapter;

    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_country, container, false);

        String[] gridViewString = {"Vancouver", "Totonto"};
        int[] gridViewImageId = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

        RecyclerView recyclerView = rootView.findViewById(R.id.rvStates);
        int numberOfColumns = 2;
        AutoGridLayoutManager layoutManager = new AutoGridLayoutManager(rootView.getContext(), display);
        recyclerView.setLayoutManager(layoutManager);
        //GridLayoutManager grid = new GridLayoutManager(rootView.getContext(), numberOfColumns);

        //recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), numberOfColumns));

        adapter = new CountryAdapter(rootView.getContext(), gridViewString, gridViewImageId);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

}
