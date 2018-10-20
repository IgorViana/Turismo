package com.example.igor.teste;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Place> placeList;
    private LayoutInflater mInflater;
    private ListClickListener listClickListener;

    public RestaurantAdapter(Context context, List<Place> placeList, ListClickListener listClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.placeList = placeList;
        this.listClickListener = listClickListener;
    }

    public RestaurantAdapter(Context context, List<Place> placeList) {
        this.mInflater = LayoutInflater.from(context);
        this.placeList = placeList;
        this.listClickListener = null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.restaurant, viewGroup, false);
        return new RestaurantAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Place currentPlace = placeList.get(i);

        viewHolder.testViewPlace.setText(currentPlace.getPlaceName());
        viewHolder.testViewLocation.setText(currentPlace.getPlaceLocation());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listClickListener != null)
                listClickListener.onItemSelected(currentPlace);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView testViewLocation;
        TextView testViewPlace;

        ViewHolder(View itemView) {
            super(itemView);
            testViewLocation = itemView.findViewById(R.id.placeLocation);
            testViewPlace = itemView.findViewById(R.id.placeName);
        }
    }
}
