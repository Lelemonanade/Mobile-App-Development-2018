package com.example.karolinadrobotowicz.mobiledev;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<CommunityCard> dataSet;
    // private static MyClickListener myClickListener;


    // public static class DataObjectHolder extends RecyclerView.ViewHolder
    //            implements View
    //            .OnClickListener {
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        //TODO add proj title
        // TextView projTitle;
        // TODO add tags
        //TextView tags;
        TextView time;
        TextView description;
        ImageView userImage;
        ImageView projImage;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView) itemView.findViewById(R.id.username);
            time = (TextView) itemView.findViewById(R.id.postTime);
            description = (TextView) itemView.findViewById(R.id.postDescription);
            userImage = (ImageView) itemView.findViewById(R.id.userImage);
            projImage = (ImageView) itemView.findViewById(R.id.postImage);
        }
    }

    public CardsAdapter(ArrayList<CommunityCard> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.community_card, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        // TODO how to add images
        //holder.userImage = dataSet.get(position).getUserImagePath();
        holder.userName.setText(dataSet.get(position).getUserName());
        holder.description.setText(dataSet.get(position).getDescription());
        holder.time.setText(dataSet.get(position).getTime());
        //holder.projImage.setImageURI(dataSet.get(position).getUserImagePath());
        //holder.projImage.setImageURI(dataSet.get(position).getUserImagePath());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
