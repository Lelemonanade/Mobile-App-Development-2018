package com.example.karolinadrobotowicz.mobiledev;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Intent intent = new Intent(this, activity_community.class);
        startActivity(intent);
    }

}
