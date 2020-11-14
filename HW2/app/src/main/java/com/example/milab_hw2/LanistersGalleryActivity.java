package com.example.milab_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LanistersGalleryActivity extends GalleryActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanisters_gallery);

        String[] lannisters_data = {"Sersei", "And such"};
        int[] images = {}; //To be implemented
        init(lannisters_data, images);
    }
}