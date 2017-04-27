package com.example.kosta.imagegallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by kosta on 2017-04-27.
 */

public class FragmentImageView extends Fragment {
    private Integer itemData;
    private ImageView image;

    public static FragmentImageView newInstance() {
        FragmentImageView fi = new FragmentImageView();
        return fi;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.image_view, container, false);
        image = (ImageView)root.findViewById(R.id.imageView);

        new LoadImageTask().execute();

        return root;
    }

    public void setItemData(Integer itemData) {
        this.itemData = itemData;
    }

    private class LoadImageTask extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... params) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;

            Bitmap bitmap = BitmapFactory.decodeResource(
                    getResources(),
                    itemData,
                    options);

            if(bitmap != null) {
                return bitmap;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(image != null) {
                image.setImageBitmap(bitmap);
            }
        }
    }
}
