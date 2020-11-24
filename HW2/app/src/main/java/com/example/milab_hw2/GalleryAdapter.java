package com.example.milab_hw2;

import android.content.Context;
import android.view.LayoutInflater;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.gallery_row, parent, false);
        GalleryViewHolder holder = new GalleryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.characterName.setText(this.data[position]);
        holder.characterImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        private TextView characterName;
        private ImageView characterImage;
        public GalleryViewHolder(View itemView) {
            super(itemView);
            characterName = itemView.findViewById(R.id.character_name);
            characterImage = itemView.findViewById(R.id.character_image);
        }
    }
}
