package com.example.milab_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LanistersGalleryActivity extends GalleryActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanisters_gallery);

        String[] lannisters_data = getResources().getStringArray(R.array.lannisters);
        int[] images = {R.drawable.tyrion, R.drawable.jaime, R.drawable.tommen,
                        R.drawable.myrcella, R.drawable.kevan, R.drawable.tywin,
                        R.drawable.lancel, R.drawable.cersei, R.drawable.joffrey};
        init(lannisters_data, images);
    }
}