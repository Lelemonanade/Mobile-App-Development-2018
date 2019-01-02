package com.example.karolinadrobotowicz.mobiledev;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CommunityActivity extends AppCompatActivity {

    //private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    //static View.OnClickListener myOnClickListener;
    //private static ArrayList<Integer> removedItems;

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


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

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Cards");
        mAuth = FirebaseAuth.getInstance();
        // TODO login
       /* mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (mAuth.getCurrentUser()==null){
                    Intent loginIntent = new Intent(CommunityActivity.this, RegisterActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);startActivity(loginIntent);
                }}};*/

        //adapter = new CardsAdapter(getData());
        //recyclerView.setAdapter(adapter);

    }

    // Setting up an adapter
    @Override
    protected void onStart() {
        super.onStart();
        // TODO login
        //mAuth.addAuthStateListener(mAuthListener);
        FirebaseRecyclerAdapter<CommunityCard, CommunityViewHolder> FBRA = new FirebaseRecyclerAdapter<CommunityCard, CommunityViewHolder>(
                CommunityCard.class,
                R.layout.community_card,
                CommunityViewHolder.class,
                mDatabase
                ) {
                    @Override
                    protected void populateViewHolder(CommunityViewHolder viewHolder, CommunityCard card, int position) {

                        final String post_key = getRef(position).getKey().toString();
                        viewHolder.setTitle(card.getProjTitle());
                        viewHolder.setDesc(card.getDescription());
                        //TODO add tags
                        // TODO add user image
                        viewHolder.setImageUrl(card.getImagePath());
                        viewHolder.setUserName(card.getUserName());

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

        public void setImageUrl(Uri imageUri){
            ImageView projImage = (ImageView) itemView.findViewById(R.id.postImage);
            projImage.setImageURI(null);
            projImage.setImageURI(imageUri);
            //Picasso.with(ctx).load(imageUrl).into(projImage);
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


    /*
    //TODO if we need menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    } @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_add) {
            startActivity(new Intent(MainActivity.this, PostActivity.class));
        } else if (id == R.id.logout){
            mAuth.signOut();
            Intent logouIntent = new Intent(MainActivity.this, RegisterActivity.class);
            logouIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(logouIntent);
        } return super.onOptionsItemSelected(item);
    }}*/


    public void goToCamera(View view) {
        Log.d("switch", "called method shortcut go to Camera");

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

    /*private ArrayList<CommunityCard> getData(){
        ArrayList data = new ArrayList<CommunityCard>();
        for(int i=0; i <2; i++){
            data.add(i, new CommunityCard());
        }
        return data;
    }*/

}
