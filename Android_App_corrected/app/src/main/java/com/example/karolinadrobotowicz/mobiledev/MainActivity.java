package com.example.karolinadrobotowicz.mobiledev;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void shortcutAddDescription(View view){
        //TODO remove
        Log.d("switch", "called method shortcut add description");
        Intent intent = new Intent(this, AddDescription.class);
        startActivity(intent);
    }

}
