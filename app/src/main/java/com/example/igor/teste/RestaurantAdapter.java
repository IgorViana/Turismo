package com.example.igor.teste;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private String[] name;
    private String[] location;
    private LayoutInflater mInflater;

    public RestaurantAdapter(Context context, String[] name, String[] location) {
        this.mInflater = LayoutInflater.from(context);
        this.name = name;
        this.location = location;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.restaurant, viewGroup, false);
        return new RestaurantAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.testViewPlace.setText(name[i]);
        viewHolder.testViewLocation.setText(location[i]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView testViewLocation;
        TextView testViewPlace;

        ViewHolder(View itemView) {
            super(itemView);
            testViewLocation = itemView.findViewById(R.id.placeLocation);
            testViewPlace = itemView.findViewById(R.id.placeName);
        }
    }
}
