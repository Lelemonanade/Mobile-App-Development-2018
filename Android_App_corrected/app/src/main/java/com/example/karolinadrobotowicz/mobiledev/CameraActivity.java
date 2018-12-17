package com.example.karolinadrobotowicz.mobiledev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import java.io.File;

public class CameraActivity extends AppCompatActivity {

    //private TextView mTextMessage;
    private File photo;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_back:
                    //mTextMessage.setText(R.string.title_back);
                    return true;
                case R.id.navigation_take_picture:
                    //mTextMessage.setText(R.string.title_take_picture);
                    return true;
                case R.id.navigation_next:
                    //mTextMessage.setText(R.string.title_next);
                    goToAddDescription();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void goToAddDescription() {
        Log.d("switch", "called method shortcut go to Camera");

        //CommunityCard newPost = new CommunityCard(1);
        final Intent intent = new Intent(this, AddDescriptionActivity.class);
        intent.setType("image/jpg");
        //TODO change to retrieving the taken photo
        photo = new File(getFilesDir(), "foo.jpg");
        intent.putExtra("photo", Uri.fromFile(photo));

        // IF Uri only
        //Uri pictureUri = Uri.parse("file://my_picture");
        //intent.putExtra("photoUri, pictureUri");

        //TODO add code

        startActivity(intent);
    }

}
