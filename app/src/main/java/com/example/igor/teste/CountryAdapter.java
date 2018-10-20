package com.example.igor.teste;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Observable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private Context context;
    private List<State> stateList;
    private LayoutInflater mInflater;
    CardClickListener cardClickListener;

    // data is passed into the constructor
    public CountryAdapter(Context context, List<State> stateList, CardClickListener cardClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.stateList = stateList;
        this.cardClickListener = cardClickListener;
    }

    public CountryAdapter(Context context, List<State> stateList) {
        this.mInflater = LayoutInflater.from(context);
        this.stateList = stateList;
        this.cardClickListener = null;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.state, parent, false);
        return new CountryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CountryAdapter.ViewHolder viewHolder, final int i) {
        final State currentState = stateList.get(i);

        viewHolder.myTextView.setText(currentState.getmStateName());
        viewHolder.myImageId.setImageResource(currentState.getImageResourceId());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardClickListener != null)
                cardClickListener.onCardSelected(currentState);
            }
        });

    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;
        ImageView myImageId;

        ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            myTextView = itemView.findViewById(R.id.CountryName);
            myImageId = itemView.findViewById(R.id.CountryImage);
        }
    }

}
