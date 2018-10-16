package com.example.igor.teste;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class CountryFragment extends Fragment {

    CountryAdapter adapter;

    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_country, container, false);

        String[] gridViewString = {"Ontário", "Quebec", "Colúmbia Britânica", "Alberta", "Nova Escócia", "Manitoba",
                "Saskatchewan", "New Brunswick", "Terra Nova e Labrador", "Ilha do Príncipe Eduardo\n"};
        int[] gridViewImageId = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

        RecyclerView recyclerView = rootView.findViewById(R.id.rvStates);
        int numberOfColumns = 2;
        AutoGridLayoutManager layoutManager = new AutoGridLayoutManager(rootView.getContext(), 500);
        recyclerView.setLayoutManager(layoutManager);
        //GridLayoutManager grid = new GridLayoutManager(rootView.getContext(), numberOfColumns);

        //recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), numberOfColumns));

        adapter = new CountryAdapter(rootView.getContext(), gridViewString, gridViewImageId);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListner(new CountryAdapter.OnItemClickListner(){

            @Override
            public void OnItemClicked(View view, int position) {

                LatLng newLocation;
                switch (position) {
                    case 0:
                        newLocation = new LatLng(48, -83);
                        break;

                    case 1:
                        newLocation = new LatLng(46, -71);
                        break;

                    case 2:
                        newLocation = new LatLng(53, -127);
                        break;

                    case 3:
                        newLocation = new LatLng(53, -113);
                        break;

                    case 4:
                        newLocation = new LatLng(45, -62);
                        break;

                    case 5:
                        newLocation = new LatLng(53, -98);
                        break;

                    case 6:
                        newLocation = new LatLng(52, -106);
                        break;

                    case 7:
                        newLocation = new LatLng(46, -66);
                        break;

                    case 8:
                        newLocation = new LatLng(48, -54);
                        break;

                    case 9:
                        newLocation = new LatLng(46, -63);
                        break;

                    default:
                        newLocation = new LatLng(-34, 151);
                        break;
                }
                //Create a bundle to pass data, add data, set the bundle to your fragment and:
                //activity.getSupportFragmentManager().beginTransaction().attach(myFragment).commit();
                //activity.getSupportFragmentManager().beginTransaction().replace(R.id.viewpager, myFragment).commit();
                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
                ((MainActivity) getContext()).setMapLocation(newLocation);
                // Set the adapter onto the view pager
                viewPager.setCurrentItem(4);
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

}
