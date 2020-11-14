package com.example.milab_hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class StarksGalleryActivity extends GalleryActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starks_gallery);

        String[] starks_data= {"Arya", "And such"};
        int[] images = {}; //To be implemented
        init(starks_data, images);
    }
}