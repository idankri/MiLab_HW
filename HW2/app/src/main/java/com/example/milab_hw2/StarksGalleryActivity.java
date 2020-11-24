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

        String[] starks_data = getResources().getStringArray(R.array.starks);
        int[] images = {R.drawable.ned, R.drawable.arya, R.drawable.catelyn,
                        R.drawable.benjen, R.drawable.bran, R.drawable.sansa,
                        R.drawable.jon_snow, R.drawable.rickon, R.drawable.robb};
        init(starks_data, images);
    }
}