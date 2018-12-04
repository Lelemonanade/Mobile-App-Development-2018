package com.example.karolinadrobotowicz.mobiledev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import static com.example.karolinadrobotowicz.mobiledev.R.id.projectTitle;

public class AddDescription extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("contructor", "called contructor of add description class.");
        setContentView(R.layout.activity_adddescription);
    }

    protected void postProject(View view){
        EditText titleField = findViewById(R.id.projectTitle);
        EditText descriptionField = findViewById(R.id.projectDescription);
        EditText tagsField = findViewById(R.id.projectTags);
        String title = titleField.getText().toString();
        String description = descriptionField.getText().toString();
        String tags = tagsField.getText().toString();

        String[] tagList = tags.split(" ");


        //Log.d("titletext", title);

    }

    public void goToCommunity(View view) {
        Log.d("switch", "called method shortcut go to Community");
        postProject(view);

        //CommunityCard newPost = new CommunityCard(1);
        Intent intent = new Intent(this, CommunityActivity.class);

        //intent.putExtra("newPost")
        startActivity(intent);
    }

}
