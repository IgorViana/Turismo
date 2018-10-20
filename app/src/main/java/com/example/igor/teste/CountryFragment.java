package com.example.igor.teste;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class CountryFragment extends Fragment implements CardClickListener{

    CountryAdapter adapter;

    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_country, container, false);

        List<State> stateList = new ArrayList<>();
        stateList.add(new State(R.drawable.ontario, getResources().getString(R.string.provincia1), new LatLng(48, -83)));
        stateList.add(new State(R.drawable.quebec, getResources().getString(R.string.provincia2), new LatLng(46, -71)));
        stateList.add(new State(R.drawable.columbia_britanica, getResources().getString(R.string.provincia3), new LatLng(53, -127)));
        stateList.add(new State(R.drawable.alberta, getResources().getString(R.string.provincia4), new LatLng(53, -113)));
        stateList.add(new State(R.drawable.novaescocia, getResources().getString(R.string.provincia5), new LatLng(45, -62)));
        stateList.add(new State(R.drawable.manitoba, getResources().getString(R.string.provincia6), new LatLng(53, -98)));
        stateList.add(new State(R.drawable.saskatchewan, getResources().getString(R.string.provincia7), new LatLng(52, -106)));
        stateList.add(new State(R.drawable.new_burnswick, getResources().getString(R.string.provincia8), new LatLng(46, -66)));
        stateList.add(new State(R.drawable.terranovaelabrador, getResources().getString(R.string.provincia9), new LatLng(48, -54)));
        stateList.add(new State(R.drawable.ilhaprincipeedward, getResources().getString(R.string.provincia10), new LatLng(46, -63)));
        //stateList.add(new State(R.drawable.ontario, getResources().getString(R.string.provincia1), new LatLng(-34, 151)));

        RecyclerView recyclerView = rootView.findViewById(R.id.rvStates);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new CountryAdapter(rootView.getContext(), stateList, this);
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onCardSelected(State state) {
        LatLng newLocation = state.getmLagLng();
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        ((MainActivity) getContext()).setMapLocation(newLocation);
        // Set the adapter onto the view pager
        viewPager.setCurrentItem(4);
    }
}
