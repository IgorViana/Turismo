package com.example.igor.teste;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AttractionsFragment extends Fragment {
    CountryAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attractions, container, false);

        String[] attractionNameString = {"Parque Nacional Banff", "Parque Nacional Jasper", "Parque Stanley"
                , "Torre CN", "Lago Moraine", "Lago Louise"
                , "Parque Nacional Yoho", "Jardins de Butchart", "Ponte Suspensa de Capilano"};
        int[] attractionImageId = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
                , R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
                , R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

        RecyclerView recyclerView = rootView.findViewById(R.id.rvAttraction);
        int numberOfColumns = 3;
        //AutoGridLayoutManager layoutManager = new AutoGridLayoutManager(rootView.getContext(), 500);
        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), numberOfColumns));

        adapter = new CountryAdapter(rootView.getContext(), attractionNameString, attractionImageId);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }
}
