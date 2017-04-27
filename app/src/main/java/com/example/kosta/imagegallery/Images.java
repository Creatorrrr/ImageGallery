package com.example.kosta.imagegallery;

import java.util.ArrayList;

/**
 * Created by kosta on 2017-04-27.
 */

public class Images {
    private ArrayList<Integer> imageId;

    public Images() {
        imageId = new ArrayList<>();
        imageId.add(R.drawable.cat1);
        imageId.add(R.drawable.cat2);
        imageId.add(R.drawable.cat3);
        imageId.add(R.drawable.cat4);
        imageId.add(R.drawable.cat5);
        imageId.add(R.drawable.cat6);
        imageId.add(R.drawable.cat7);
        imageId.add(R.drawable.cat8);
        imageId.add(R.drawable.cat9);
        imageId.add(R.drawable.cat10);
    }

    public ArrayList<Integer> getImageItem() {
        return imageId;
    }
}
