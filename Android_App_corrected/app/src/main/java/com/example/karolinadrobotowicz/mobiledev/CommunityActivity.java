package com.example.karolinadrobotowicz.mobiledev;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.InputStream;
import java.util.List;


public class CommunityActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    //static View.OnClickListener myOnClickListener;

    private DatabaseReference mDatabase;
    private static StorageReference storageRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Cards");
        storageRef = FirebaseStorage.getInstance().getReference().child("post_images");

       /* TODO login
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (mAuth.getCurrentUser()==null){
                    Intent loginIntent = new Intent(CommunityActivity.this, RegisterActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);startActivity(loginIntent);
                }}};*/
    }


    @Override
    protected void onStart() {
        super.onStart();

        // TODO login
        //mAuth.addAuthStateListener(mAuthListener);

        // Setting up an adapter
        FirebaseRecyclerAdapter<CommunityCard, CommunityViewHolder> FBRA = new FirebaseRecyclerAdapter<CommunityCard, CommunityViewHolder>(
                CommunityCard.class,
                R.layout.community_card,
                CommunityViewHolder.class,
                mDatabase
                ) {
                    @Override
                    protected void populateViewHolder(CommunityViewHolder viewHolder, CommunityCard card, int position) {

                        //final String post_key = getRef(position).getKey().toString();
                        viewHolder.setTitle(card.getTitle());
                        viewHolder.setDesc(card.getDesc());
                        viewHolder.setTags(card.getTags());
                        viewHolder.setTime(card.getTime());
                        // TODO add user image and username
                        viewHolder.setImageUrl(CommunityActivity.this, card.getImageUrl());
                        viewHolder.setUserName(card.getUsername());
                        // shows null for now
                        Log.d("CommunityImage", card.getImageUrl());


                        /* TODO if we want singleActivity class
                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent singleActivity = new Intent(CommunityActivity.this, SinglePostActivity.class);
                                singleActivity.putExtra("postID", post_key);
                                startActivity(singleActivity);
                        } });*/
                    }};

        recyclerView.setAdapter(FBRA);
    }

    // Setting up the holder - putting right things on the right place
    public static class CommunityViewHolder extends RecyclerView.ViewHolder{

        View mView;
        public CommunityViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setTitle(String title){
            TextView projTitle = (TextView) itemView.findViewById(R.id.projectTitle);

            projTitle.setText(title);
        }

        public void setDesc(String desc){
            TextView description = (TextView) itemView.findViewById(R.id.postDescription);
            description.setText(desc);
        }

        public void setTags(List<String> tags){
            //TODO work on better tags representations
            TextView tagsPlace = (TextView) itemView.findViewById(R.id.postTags);
            if(!tags.isEmpty()){
                tags.add(0, "");
                tagsPlace.setText(TextUtils.join(" #", tags));
            }

        }

        public void setImageUrl(Context ctx, String imageUri){

            StorageReference fileRef = storageRef.child(imageUri);
            ImageView projImage = (ImageView) itemView.findViewById(R.id.postImage);
            //projImage.setImageURI(null);
            //projImage.setImageURI(imageUri);
            //Picasso.with(context).load(imageUri).into(projImage);
            GlideApp.with(ctx)
                    .load(fileRef)
                    .into(projImage);
        }

        public void setUserName(String userName){
            TextView postUserName = mView.findViewById(R.id.username);
            postUserName.setText(userName);
        }

        public void setTime(String time) {
            TextView postTime = mView.findViewById(R.id.postTime);
            postTime.setText(time);
        }
    }


    public void goToCamera(View view) {
        Log.d("switch", "called method shortcut go to Camera");

        Intent intent = new Intent(this, CameraActivity.class);

        //intent.putExtra("newPost")
        startActivity(intent);
    }


    public void notDeveloped(View view){
        Snackbar.make(findViewById(R.id.coordinatorLayout),
                R.string.notdeveloped, Snackbar.LENGTH_SHORT).show();
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



}

