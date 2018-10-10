package com.example.igor.teste;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentAdapter extends FragmentPagerAdapter {

    /** Contexto do aplicativo */
    private Context mContext;

    public SimpleFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.estados);
        } else if (position == 1) {
            return mContext.getString(R.string.restaurantes);
        } else if (position == 2) {
            return mContext.getString(R.string.atracoes);
        } else if (position == 3) {
            return mContext.getString(R.string.cidades);
        } else {
            return mContext.getString(R.string.mapa);
        }
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new CountryFragment();
        } else if (i == 1) {
            return new RestaurantFragment();
        } else if (i == 2) {
            return new AttractionsFragment();
        } else if (i == 3) {
            return new CityFragment();
        } else {
            return new MapsActivity();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
