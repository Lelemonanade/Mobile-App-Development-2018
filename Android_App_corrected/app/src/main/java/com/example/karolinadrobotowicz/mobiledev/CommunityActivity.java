package com.example.karolinadrobotowicz.mobiledev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class CommunityActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    //static View.OnClickListener myOnClickListener;
    //private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);

        //removedItems = new ArrayList<Integer>();

        adapter = new CardsAdapter(getData());
        recyclerView.setAdapter(adapter);

    }

    public void goToCamera(View view) {
        Log.d("switch", "called method shortcut go to Camera");

        //CommunityCard newPost = new CommunityCard(1);
        Intent intent = new Intent(this, CameraActivity.class);

        //intent.putExtra("newPost")
        startActivity(intent);
    }


    /*
    @Override
    protected void onResume() {
        super.onResume();
        ((CardsAdapter) adapter).setOnItemClickListener(new CardsAdapter()
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }*/

    private ArrayList<CommunityCard> getData(){
        ArrayList data = new ArrayList<CommunityCard>();
        for(int i=0; i <2; i++){
            data.add(i, new CommunityCard());
        }
        return data;
    }




}
