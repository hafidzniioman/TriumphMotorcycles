package com.example.hafidzniioman.triumphmotorcycles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by hafidzniioman on 21/02/18.
 */

public class GridMotorAdapter extends RecyclerView.Adapter<GridMotorAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<Motor> listMotor;

    public GridMotorAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Motor> getListMotor() {
        return listMotor;
    }

    public void setListMotor(ArrayList<Motor> listMotor) {
        this.listMotor = listMotor;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_motor, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListMotor().get(position).getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMotor().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
        }
    }
}

