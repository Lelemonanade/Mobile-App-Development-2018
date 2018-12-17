package com.example.karolinadrobotowicz.mobiledev;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

    }

    public void notDeveloped(View view){
        Snackbar.make(findViewById(R.id.coordinatorLayout),
                R.string.notdeveloped, Snackbar.LENGTH_SHORT).show();
    }

    public void goToCommunity(View view) {
        Log.d("switch", "called method shortcut go to community");

        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    }

    public void goToAddDescription(View view) {
        Log.d("switch", "called method shortcut go to Camera");

        //CommunityCard newPost = new CommunityCard(1);
        Intent intent = new Intent(this, AddDescriptionActivity.class);

        //intent.putExtra("newPost")
        startActivity(intent);
    }

}
