package com.example.kosta.imagegallery;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener{

    private Button prev, next;

    private int position, totalImage;
    private ViewPager viewPager;
    private ArrayList<Integer> itemData;

    private FragmentPagerAdapter adapter;
    private Images imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        prev = (Button)findViewById(R.id.prev);
        next = (Button)findViewById(R.id.next);

        imageId = new Images();
        itemData = imageId.getImageItem();
        totalImage = itemData.size();

        setPage(position);

        adapter = new FragmentPagerAdapter(getSupportFragmentManager(), itemData);

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(this);
    }

    public void clickEvent(View view) {
        if(view == prev) {
            position--;
            viewPager.setCurrentItem(position);
        } else if(view == next) {
            position++;
            viewPager.setCurrentItem(position);
        }
    }

    private void setPage(int page) {
        if(page == 0 && totalImage > 0) {
            next.setVisibility(View.VISIBLE);
            prev.setVisibility(View.INVISIBLE);
        } else if(page == totalImage - 1 && totalImage > 0) {
            next.setVisibility(View.INVISIBLE);
            prev.setVisibility(View.VISIBLE);
        } else {
            next.setVisibility(View.VISIBLE);
            prev.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;
        setPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
