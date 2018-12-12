package com.example.karolinadrobotowicz.mobiledev;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommunityCard {

    private static String LOG_TAG = "CommunityCard";
    private String projTitle;
    private String userName;
    private String time;
    private String description;
    private String imagePath;
    private String userImagePath;
    private String codePath;
    private int cardType; // 0-null, 1-project, 2-question
    //TODO tags as an array
    private String tags;

    /**
     * The contstructor which creates an already filled demo card
     */
    public CommunityCard(){
        Log.d(LOG_TAG, "onCardCreation");
        this.cardType = cardType;
        this.userName = "Mimi";
        this.userImagePath = "@drawable/user1";
        this.projTitle = "lorem ipsum";
        this.description = "dorimo dorimi fahita";
        this.tags = "lol, bmc, amazing";
        this.imagePath = "@drawable/imagi1";
        setTime();
    }

    public CommunityCard(int cardType){
        Log.d(LOG_TAG, "onCardCreation with the type");
        this.cardType = cardType;
        this.userName = "Mimi";
        this.userImagePath = "@drawable/user1";
        if(cardType == 2){
            // have a path to the image of quesiton mark or only code
        }
        setTime();
    }

    public CommunityCard(int cardType, String userName, String userImagePath){

        Log.d(LOG_TAG, "onCreation with the Type and name");
        this.cardType = cardType;
        this.userName = userName;
        this.userImagePath = userImagePath;
        setTime();
    }

    public void setTime(){

        Log.d(LOG_TAG, "setTime");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        this.time = formatter.format(date);
    }

    public void setImagePath(String imagePath){

        Log.d(LOG_TAG, "SetImagePAth");
        this.imagePath = imagePath;
    }

    public void setTexts(String projTitle, String description, String tags){

        Log.d(LOG_TAG, "setText");
        this.projTitle = projTitle;
        this.description = description;
        this.tags = tags;
        setTime();
    }

    public String getProjTitle(){
        return this.projTitle;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getTime(){
        return this.time;
    }

    public String getDescription(){
        return this.description;
    }

    public String getImagePath(){
        return this.imagePath;
    }

    public String getUserImagePath(){
        return this.userImagePath;
    }

    public String getCodePath(){
        return this.codePath;
    }

    public String getTags(){
        return this.tags;
    }

}
