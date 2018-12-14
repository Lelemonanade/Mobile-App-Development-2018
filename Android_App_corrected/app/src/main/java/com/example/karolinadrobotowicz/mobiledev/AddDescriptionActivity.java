package com.example.karolinadrobotowicz.mobiledev;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import static com.example.karolinadrobotowicz.mobiledev.R.id.projectTitle;

public class AddDescriptionActivity extends AppCompatActivity {

    private StorageReference storage;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseUsers;
    private FirebaseUser mCurrentUser;

    private Uri uri = null;

    private EditText titleField;
    private EditText descriptionField;
    private EditText tagsField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("contructor", "called contructor of add description class.");
        setContentView(R.layout.activity_adddescription);

        titleField = (EditText) findViewById(R.id.projectTitle);
        descriptionField = (EditText) findViewById(R.id.projectDescription);
        tagsField = (EditText) findViewById(R.id.projectTags);

        storage = FirebaseStorage.getInstance().getReference();
        //TODO this to change
        databaseRef = database.getInstance().getReference().child("Blogzone");
        mAuth = FirebaseAuth.getInstance();

        //TODO what about users?
        mCurrentUser = mAuth.getCurrentUser();
        mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());

    }

    protected void postProject(View view){

        String title = titleField.getText().toString();
        String description = descriptionField.getText().toString();
        String tags = tagsField.getText().toString();

        String[] tagList = tags.split(" ");


        //Log.d("titletext", title);

    }

    public void goToCommunity(View view) {
        Log.d("switch", "called method shortcut go to Community");

        Toast.makeText(AddDescriptionActivity.this, "POSTING…", Toast.LENGTH_LONG).show();
        final String title = titleField.getText().toString().trim();
        final String description = descriptionField.getText().toString().trim();
        final String tags = tagsField.getText().toString().trim();

        String[] tagList = tags.split(" ");

        // do a check for empty fields
        if (!TextUtils.isEmpty(description) && !TextUtils.isEmpty(title)){

            StorageReference filepath = storage.child("post_images").child(uri.getLastPathSegment());

            /* IMAGE AND POST UPLOAD -> RECEIVE THE IMAGE FROM THE PREVIOUS POST FIRST
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    @SuppressWarnings("VisibleForTests")
                    //getting the post image download url
                    final Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    Toast.makeText(getApplicationContext(), "Succesfully Uploaded", Toast.LENGTH_SHORT).show();
                    final DatabaseReference newPost = databaseRef.push();
                    //adding post contents to database reference
                    mDatabaseUsers.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            newPost.child("title").setValue(PostTitle);
                            newPost.child("desc").setValue(PostDesc);
                            newPost.child("imageUrl").setValue(downloadUrl.toString());
                            newPost.child("uid").setValue(mCurrentUser.getUid());
                            newPost.child("username").setValue(dataSnapshot.child("name").getValue())
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Intent intent = new Intent(PostActivity.this, MainActivity.class);
                                                startActivity(intent);
                                            }}});}
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        } }); } });*/

        }


        postProject(view);




        //CommunityCard newPost = new CommunityCard(1);
        Intent intent = new Intent(this, CommunityActivity.class);

        //intent.putExtra("newPost")
        startActivity(intent);
    }

}
