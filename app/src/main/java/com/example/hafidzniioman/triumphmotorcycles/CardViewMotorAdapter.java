package com.example.hafidzniioman.triumphmotorcycles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by hafidzniioman on 21/02/18.
 */

public class CardViewMotorAdapter extends RecyclerView.Adapter<CardViewMotorAdapter.CardViewViewHolder> {
    private ArrayList<Motor>listMotor;
    private Context context;

    public CardViewMotorAdapter(Context context){
        this.context = context;
    }

    public ArrayList<Motor> getListMotor() {
        return listMotor;
    }

    public void setListMotor(ArrayList<Motor> listMotor){
        this.listMotor = listMotor;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_motor, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {

        Motor m = getListMotor().get(position);

        Glide.with(context)
                .load(m.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(m.getName());
        holder.tvRemarks.setText(m.getRemarks());

        holder.btnFavorite.setOnClickListener(new CustomOnClickListener(position, new CustomOnClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListMotor().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnClickListener(position, new CustomOnClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Detail " + getListMotor().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListMotor().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;
        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = (Button)itemView.findViewById(R.id.btn_set_favorite);
            btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
        }
    }
}
