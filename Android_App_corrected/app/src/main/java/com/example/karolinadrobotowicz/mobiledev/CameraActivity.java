package com.example.karolinadrobotowicz.mobiledev;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.app.PendingIntent.getActivity;

public class CameraActivity extends Activity {

    //private TextView mTextMessage;
    private File photo;

    private CameraPreview mPreview;

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
                    Log.d("foto", "navigation listener");
                    mPreview.capture();
                    return true;
                case R.id.navigation_next:
                    //mTextMessage.setText(R.string.title_next);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Log.d("foto", "camera activity creation");

        //mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mPreview= new CameraPreview(this.getApplicationContext(), this);

        FrameLayout layout = (FrameLayout)findViewById(R.id.cameraFrame);
        layout.addView(mPreview);

        FrameLayout cameraControlFrame = (FrameLayout)findViewById(R.id.cameraControlFrame);
        cameraControlFrame.bringToFront();
    }

    public void capture(View view){
        Log.d("foto", "trigger button method");
        mPreview.capture();
    }

    public void goToAddDescription(View view) {
        Log.d("switch", "called method shortcut go to Camera");

        //CommunityCard newPost = new CommunityCard(1);


        final Intent intent = new Intent(this, AddDescriptionActivity.class);
        //TODO change to retrieving the taken photo

        Uri pictureUri = Uri.parse("android.resource://com.example.karolinadrobotowicz.mobiledev/"+R.drawable.ic_image_placeholder);
        intent.setData(pictureUri);

        startActivity(intent);
    }


}
