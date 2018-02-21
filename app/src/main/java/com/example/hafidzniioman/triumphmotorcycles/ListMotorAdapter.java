package com.example.hafidzniioman.triumphmotorcycles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by hafidzniioman on 21/02/18.
 */

public class ListMotorAdapter extends RecyclerView.Adapter<ListMotorAdapter.CategoryViewHolder> {
    private Context context;

    public ArrayList<Motor> getListMotor(){
        return listMotor;
    }

    public void setListMotor(ArrayList<Motor> listMotor){
        this.listMotor = listMotor;
    }

    private ArrayList<Motor>listMotor;

    public ListMotorAdapter(Context context){
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_motor, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListMotor().get(position).getName());
        holder.tvRemarks.setText(getListMotor().get(position).getRemarks());

        Glide.with(context)
                .load(getListMotor().get(position).getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount(){
        return getListMotor().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
        }
    }
    }
