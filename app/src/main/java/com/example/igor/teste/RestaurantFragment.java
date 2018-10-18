package com.example.igor.teste;

import android.content.Context;
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
        adapter.setOnRestaurantClickListener(new RestaurantAdapter.OnRestaurantClickListener(){
            @Override
            public void OnRestaurantClicked(View view, int position) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri;

                switch (position) {
                    case 0:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/i4rgU4wZTNN2");
                        break;

                    case 1:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/q4Undf4F6382");
                        break;

                    case 2:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/KVZeqrjVoxr");
                        break;

                    case 3:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/gg9FtCQG44x");
                        break;

                    case 4:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/tHy58fHLshE2");
                        break;

                    case 5:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/KNqynyrUPUy");
                        break;

                    case 6:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/XyYoAX3bevD2");
                        break;

                    case 7:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/cZXzKy3zxrk");
                        break;

                    case 8:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/ELFJj7qggyE2");
                        break;

                    case 9:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/gn4eJjtmfCr");
                        break;

                    default:
                        gmmIntentUri = Uri.parse("https://goo.gl/maps/i4rgU4wZTNN2");
                        break;
                }
                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    // Attempt to start an activity that can handle the Intent
                    startActivity(mapIntent);
                }
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}
