package com.example.igor.teste;

import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private Context context;
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
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.myTextView.setText(name[i]);
        viewHolder.myImageId.setImageResource(imageId[i]);

        viewHolder.myImageId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*int clickPosition = i;

                final Intent intent;
                switch (clickPosition){
                    case 0:
                        intent =  new Intent(context, MapsActivity.class);
                        break;

                    case 1:
                        intent =  new Intent(context, MapsActivity.class);
                        break;

                    default:
                        intent =  new Intent(context, MapsActivity.class);
                        break;
                } */
                //You can change the fragment, something like this, not tested, please correct for your desired output:
                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                //Create a bundle to pass data, add data, set the bundle to your fragment and:
                //activity.getSupportFragmentManager().beginTransaction().attach(myFragment).commit();
                //activity.getSupportFragmentManager().beginTransaction().replace(R.id.viewpager, myFragment).commit();

                ViewPager viewPager = (ViewPager) activity.findViewById(R.id.viewpager);
                // Set the adapter onto the view pager
                viewPager.setCurrentItem(4);

            }
        });
    }

    @Override
    public int getItemCount() {
        return imageId.length;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
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
