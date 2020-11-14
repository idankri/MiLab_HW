package com.example.milab_hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public abstract class GalleryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

    }

    void init(String[] data, int[] images){
        GalleryAdapter adapter = new GalleryAdapter(this.getBaseContext(), data, new int[2]);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
        recyclerView.setAdapter(adapter);
    }
}