package com.example.hafidzniioman.triumphmotorcycles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by hafidzniioman on 26/02/18.
 */

public class DetailMotorActivity extends AppCompatActivity {

    public static String EXTRA_DATA = "extra_data";
    private TextView tvName;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_triumph);
        Motor motor = getIntent().getParcelableExtra(EXTRA_DATA);
        imgPhoto = (ImageView) findViewById(R.id.img_item_photo);
        Glide.with(DetailMotorActivity.this)
                .load(motor.getPhoto())
                .override(600, 600)
                .into(imgPhoto);

        tvName = (TextView) findViewById(R.id.tv_detail_name);
        tvName.setText(motor.getName());
    }
}
