package com.example.igor.teste;

import android.content.Context;
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

public class RestaurantFragment extends Fragment {
    RestaurantAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant, container, false);

        String[] restaurantNameString = {"Alo", "Toqué!", "Joe Beef", "Buca Osteria & Bar", "Langdon Hall", "Montréal Plaza",
                "Raymonds", "Le Vin Papillon", "Edulis ", "Kissa Tanto"};
        String[] restaurantLocationString = {"Toronto, Ont", "Montreal, Que", "Montreal, Que", "Toronto, Ont", "Cambridge, Ont",
                "Montreal, Que", "St. John's, Nl", "Montreal, Que", "Toronto, Ont", "Vancouver, BC"};

        RecyclerView recyclerView = rootView.findViewById(R.id.rvRestaurant);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        adapter = new RestaurantAdapter(rootView.getContext(), restaurantNameString, restaurantLocationString);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }
}
