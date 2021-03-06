package com.example.newstextingapp.view.slider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newstextingapp.R;
import com.example.newstextingapp.model.pojoClasses.Image;
import com.example.newstextingapp.model.pojoClasses.Results;

import java.util.ArrayList;
/*
 * Author - Levitskiy Konstantin
 */
public class TopNewsAdapter extends RecyclerView.Adapter<TopViewHolder> {
    private ArrayList<Results> results;

    public TopNewsAdapter(ArrayList<Results> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_new, parent, false);
        //final TopViewHolder holder = new TopViewHolder(view);
        return new TopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopViewHolder holder, int position) {
            final Results result = results.get(position);
            final Image image = result.getImage();
            Glide.with(holder.itemView.getContext())
                    .load(image.getUrl())
                    .into(holder.photo);
            holder.nameTv.setText(result.getName());
            holder.costTv.setText("  -   " + result.getPrice());
            holder.typeTv.setText(result.getCurrency().getId());
    }

    @Override
    public int getItemCount() {
        return (results == null) ? 0 : 10;
    }
}
