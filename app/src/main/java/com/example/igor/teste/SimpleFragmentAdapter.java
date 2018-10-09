package com.example.igor.teste;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentAdapter extends FragmentPagerAdapter {

    public SimpleFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new CountryFragment();
        } else if (i == 1) {
            return null;
        } else if (i == 2) {
            return null;
        } else if (i == 3) {
            return null;
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 1;
    }
}
