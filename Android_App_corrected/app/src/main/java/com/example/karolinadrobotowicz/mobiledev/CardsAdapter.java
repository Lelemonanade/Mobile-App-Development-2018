package com.example.karolinadrobotowicz.mobiledev;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder> {

    private static String LOG_TAG = "CardsAdapter";
    private ArrayList<CommunityCard> dataSet;
    // private static MyClickListener myClickListener;


    // public static class DataObjectHolder extends RecyclerView.ViewHolder
    //            implements View
    //            .OnClickListener {
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        //TODO add proj title
        TextView projTitle;
        // TODO add tags
        //TextView tags;
        TextView time;
        TextView description;
        ImageView userImage;
        ImageView projImage;

        public MyViewHolder(View view) {
            super(view);
            Log.d(LOG_TAG, "onCreation");
            userName = (TextView) itemView.findViewById(R.id.username);
            time = (TextView) itemView.findViewById(R.id.postTime);
            projTitle = (TextView) itemView.findViewById(R.id.projectTitle);
            description = (TextView) itemView.findViewById(R.id.postDescription);
            userImage = (ImageView) itemView.findViewById(R.id.userImage);
            projImage = (ImageView) itemView.findViewById(R.id.postImage);
        }
    }

    public CardsAdapter(ArrayList<CommunityCard> data) {
        this.dataSet = data;
        Log.d(LOG_TAG, "dataSet");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(LOG_TAG, "onCreateHolderBefore");

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.community_card, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Log.d(LOG_TAG, "onBindBefore");
        // TODO how to add images
        //holder.userImage = dataSet.get(position).getUserImagePath();
        holder.userName.setText(dataSet.get(position).getUserName());
        holder.description.setText(dataSet.get(position).getDescription());
        holder.time.setText(dataSet.get(position).getTime());
        //holder.projImage.setImageURI(dataSet.get(position).getUserImagePath());
        //holder.projImage.setImageURI(dataSet.get(position).getUserImagePath());
        Log.d(LOG_TAG, "onBindAfter");

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
