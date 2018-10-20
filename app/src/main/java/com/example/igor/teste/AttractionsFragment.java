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

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class AttractionsFragment extends Fragment {
    CountryAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attractions, container, false);

        List<State> attList = new ArrayList<>();
        attList.add(new State(R.drawable.banff, getResources().getString(R.string.atracao1)));
        attList.add(new State(R.drawable.jasper, getResources().getString(R.string.atracao2)));
        attList.add(new State(R.drawable.stanley, getResources().getString(R.string.atracao3)));
        attList.add(new State(R.drawable.cn, getResources().getString(R.string.atracao4)));
        attList.add(new State(R.drawable.moraine, getResources().getString(R.string.atracao5)));
        attList.add(new State(R.drawable.louise, getResources().getString(R.string.atracao6)));
        attList.add(new State(R.drawable.yoho, getResources().getString(R.string.atracao7)));
        attList.add(new State(R.drawable.butchart, getResources().getString(R.string.atracao8)));
        attList.add(new State(R.drawable.capilano, getResources().getString(R.string.atracao9)));

        RecyclerView recyclerView = rootView.findViewById(R.id.rvAttraction);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new CountryAdapter(rootView.getContext(), attList);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }
}
