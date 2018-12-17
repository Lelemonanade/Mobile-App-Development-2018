package com.example.karolinadrobotowicz.mobiledev;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.karolinadrobotowicz.mobiledev.R.id.projectTitle;

public class AddDescriptionActivity extends AppCompatActivity {

    private StorageReference storage;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseUsers;
    private FirebaseUser mCurrentUser;

    //the photo uri
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
        databaseRef = database.getInstance().getReference().child("Cards");
        mAuth = FirebaseAuth.getInstance();

        //TODO what about users?
        //mCurrentUser = mAuth.getCurrentUser();
        //mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());

        //TODO change depending on what are we sending
        // Receive passed URI of the photo
        Intent intent = getIntent();
        uri = intent.getData();

    }

    public void goToCommunity(View view) {
        Log.d("switch", "called method shortcut go to Community");


        Toast.makeText(AddDescriptionActivity.this, "POSTING…", Toast.LENGTH_LONG).show();
        final String title = titleField.getText().toString().trim();
        final String description = descriptionField.getText().toString().trim();
        final String tags = tagsField.getText().toString().trim();

        final String[] tagListA = tags.split(" ");
        final List<String> tagList = new ArrayList<String>(Arrays.asList(tagListA));

        // do a check for empty fields
        if (!TextUtils.isEmpty(description) && !TextUtils.isEmpty(title)){

            StorageReference filepath = storage.child("post_images").child(uri.getLastPathSegment());
            Log.d("addDesc", uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Log.d("addDesc", "onSuccess of adding the file");
                    @SuppressWarnings("VisibleForTests")
                    //getting the post image download url
                    final Uri downloadUrl = Uri.parse(taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());
                    Toast.makeText(getApplicationContext(), "Succesfully Uploaded", Toast.LENGTH_SHORT).show();

                    //adding post contents to datbase reference
                    final DatabaseReference newPost = databaseRef.push();
                    //mDatabaseUsers.addValueEventListener(new ValueEventListener() {
                    //    @Override
                    //    public void onDataChange(DataSnapshot dataSnapshot) {
                            newPost.child("title").setValue(title);
                            newPost.child("desc").setValue(description);
                            newPost.child("tags").setValue(tagList);
                            newPost.child("imageUrl").setValue(uri.toString());
                            //newPost.child("uid").setValue(mCurrentUser.getUid());
                            newPost.child("username").setValue("mimi")
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Intent intent = new Intent(AddDescriptionActivity.this, CommunityActivity.class);
                                                //TODO check if works
                                                // closing previous activities
                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                //you can also check this one: Intent.FLAG_ACTIVITY_CLEAR_TOP
                                                startActivity(intent);
                                            }
                                        }
                                    });
                        //}

                        //@Override
                        //public void onCancelled(DatabaseError databaseError) {
                        //    Log.d("addDesc", databaseError.getMessage());
                        //}
                    //});
                }
            });

        }

    }

}
