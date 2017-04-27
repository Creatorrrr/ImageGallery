package com.example.kosta.imagegallery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by kosta on 2017-04-27.
 */

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Integer> itemData;

    public FragmentPagerAdapter(FragmentManager fm, ArrayList<Integer> itemData) {
        super(fm);

        this.itemData = itemData;
    }

    @Override
    public Fragment getItem(int position) {
        FragmentImageView fi = FragmentImageView.newInstance();
        fi.setItemData(itemData.get(position));

        return fi;
    }

    @Override
    public int getCount() {
        return itemData.size();
    }
}
