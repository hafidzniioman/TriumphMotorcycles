package com.example.hafidzniioman.triumphmotorcycles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Motor> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        getSupportActionBar().setTitle("Triumph Motorcycles");

        list = new ArrayList<>();
        list.addAll(MotorType.getListMotor());

        showRecycleList();
    }

    private void showRecycleList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListMotorAdapter listMotorAdapter = new ListMotorAdapter(this);
        listMotorAdapter.setListMotor(list);
        rvCategory.setAdapter(listMotorAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMotor(list.get(position));
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridMotorAdapter gridMotorAdapter = new GridMotorAdapter(this);
        gridMotorAdapter.setListMotor(list);
        rvCategory.setAdapter(gridMotorAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMotor(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewMotorAdapter cardViewMotorAdapter = new CardViewMotorAdapter(this);
        cardViewMotorAdapter.setListMotor(list);
        rvCategory.setAdapter(cardViewMotorAdapter);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);

    }

    private void showSelectedMotor(Motor motor) {
        Toast.makeText(this, "Anda Memilih " + motor.getName(), Toast.LENGTH_SHORT).show();
        Intent moveDetail = new Intent(MainActivity.this, DetailMotorActivity.class);
        moveDetail.putExtra(DetailMotorActivity.EXTRA_DATA, motor);
        startActivity(moveDetail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = null;
        switch (item.getItemId()) {
            case R.id.action_list:
                title = "Mode List";
                showRecycleList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                title = "Mode Grid";
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);
    }

}
