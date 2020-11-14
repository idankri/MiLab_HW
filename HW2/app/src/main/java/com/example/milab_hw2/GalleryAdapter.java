package com.example.milab_hw2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>{
    private Context context;
    private String[] data;
    int[] images;
    public GalleryAdapter(Context context, String[] data, int[] images){
        this.context = context;
        this.data = data;
        this.images = images;
    }
    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ImageView imgView = new ImageView(pare)
        TextView textView = new TextView(context);
        GalleryViewHolder holder = new GalleryViewHolder(textView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        String textForDisplay = this.data[position];
        holder.mTextView.setText(textForDisplay);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        public GalleryViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView;
        }
    }
}
