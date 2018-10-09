package com.example.igor.teste;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class CountryFragment extends Fragment {

    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_country, container, false);

        GridView gridview = (GridView) rootView.findViewById(R.id.grid_view_image_text);
        String[] gridViewString = {"Vancouver", "Totonto"};
        int[] gridViewImageId = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
        /*ArrayList<State> states = new ArrayList<>();
        states.add(new State(R.drawable.ic_launcher_background, "Vancouver"));
        states.add(new State(R.drawable.ic_launcher_background, "Totonto"));*/
        gridview.setAdapter(new CountryAdapter(getActivity(), gridViewString, gridViewImageId));

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false);
    }

}
