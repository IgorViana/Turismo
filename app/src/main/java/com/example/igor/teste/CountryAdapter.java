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

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private Context context;
    private String[] name;
    private int[] imageId;
    private LayoutInflater mInflater;
    OnItemClickListener onItemClickListener;

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
    public void onBindViewHolder(@NonNull final CountryAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.myTextView.setText(name[i]);
        viewHolder.myImageId.setImageResource(imageId[i]);
        /*viewHolder.myImageId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClicked(v, i);
            }
        });*/
        /*viewHolder.myImageId.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                //You can change the fragment, something like this, not tested, please correct for your desired output:
                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                LatLng newLocation;
                switch (i) {
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
                ViewPager viewPager = (ViewPager) activity.findViewById(R.id.viewpager);
                ((MainActivity) context).setMapLocation(newLocation);
                // Set the adapter onto the view pager
                viewPager.setCurrentItem(4);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return imageId.length;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageView myImageId;

        ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            myTextView = itemView.findViewById(R.id.CountryName);
            myImageId = itemView.findViewById(R.id.CountryImage);
            myImageId.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onItemClickListener != null)
                onItemClickListener.OnItemClicked(v, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void OnItemClicked(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
