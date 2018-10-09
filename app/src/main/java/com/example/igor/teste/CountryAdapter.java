package com.example.igor.teste;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private String[] name;
    private int[] imageId;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public CountryAdapter(Context context, String[] data, int[] imageId) {
        this.mInflater = LayoutInflater.from(context);
        this.name = data;
        this.imageId = imageId;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.state, parent, false);
        return new CountryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder viewHolder, int i) {
        viewHolder.myTextView.setText(name[i]);
        viewHolder.myImageId.setImageResource(imageId[i]);
    }

    @Override
    public int getItemCount() {
        return imageId.length;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;
        ImageView myImageId;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.CountryName);
            myImageId = itemView.findViewById(R.id.CountryImage);
        }
    }
    /*public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.state, parent, false);
        }
        State currentCounty = getItem(position);

        ImageView countryImage = listItemView.findViewById(R.id.CountryImage);
        countryImage.setImageResource(currentCounty.getImageResourceId());

        TextView countryName = listItemView.findViewById(R.id.CountryName);
        countryName.setText(currentCounty.getmStateName());

        return listItemView;
    }*/

    /* private Context context;
    private final String[] gridViewString;
    private final int[] gridViewImageId;

    public CountryAdapter(Context context, String[]gridViewString, int[]gridViewImageId) {
        //super(context, 0, country);
        this.context = context;
        this.gridViewString = gridViewString;
        this.gridViewImageId = gridViewImageId;
    }

    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int position) {
        return gridViewImageId[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridViewAndroid = new View(context);
            gridViewAndroid = inflater.inflate(R.layout.state, null);
            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.CountryName);
            ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.CountryImage);
            textViewAndroid.setText(gridViewString[position]);
            imageViewAndroid.setImageResource(gridViewImageId[position]);
        } else {
            gridViewAndroid = (View) convertView;
        }

        return gridViewAndroid; */
}
