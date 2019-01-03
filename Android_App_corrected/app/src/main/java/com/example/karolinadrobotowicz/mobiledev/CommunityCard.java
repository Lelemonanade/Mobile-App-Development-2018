package com.example.karolinadrobotowicz.mobiledev;

import android.net.Uri;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommunityCard {

    private static String LOG_TAG = "CommunityCard";
    private int ID;
    private String title;
    private String username;
    private String time;
    private String desc;
    private String imageUrl;
    private Uri userImagePath;
    private String codePath;
    //private int cardType; // 0-null, 1-project, 2-question
    private List<String> tags;

    public CommunityCard(String title, String username, String desc, String imageUrl, List<String> tags, String time) {
        this.title = title;
        this.username = username;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.tags = tags;
        this.time = time;
        //setTime();
    }

    public CommunityCard(){
        Log.d(LOG_TAG, "onCardCreation");
        /*this.cardType = cardType;
        this.username = "Mimi";
        this.userImagePath = Uri.parse("android.resource://my.package.name/"+R.drawable.user1);
        this.title = "lorem ipsum";
        this.desc = "dorimo dorimi fahita";
        this.tags = "lol, bmc, amazing";
        this.imageUrl = Uri.parse("android.resource://my.package.name/"+R.drawable.imagi1);*/
        //setTime();
    }

    /* TODO check if needed
    public CommunityCard(int cardType){
        Log.d(LOG_TAG, "onCardCreation with the type");
        this.cardType = cardType;
        this.username = "Mimi";
        this.imageUrl = Uri.parse("android.resource://my.package.name/"+R.drawable.imagi1);
        if(cardType == 2){
            // have a path to the image of quesiton mark or only code
        }
        setTime();
    }

    public CommunityCard(int cardType, String username, Uri userImagePath){

        Log.d(LOG_TAG, "onCreation with the Type and name");
        this.cardType = cardType;
        this.username = username;
        this.userImagePath = userImagePath;
        setTime();
    }*/

    // SETTERS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUserImagePath(Uri userImagePath) {
        this.userImagePath = userImagePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    /*public void setCardType(int cardType) {
        this.cardType = cardType;
    }*/

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setTime(){

        Log.d(LOG_TAG, "setTime");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        this.time = formatter.format(date);
    }

    public void setImageUrl(String imageUrl){

        Log.d(LOG_TAG, "SetImagePAth");
        this.imageUrl = imageUrl;
    }


    //GETTERS

    public String getTitle(){
        return this.title;
    }

    public String getUsername(){
        return this.username;
    }

    public String getTime(){
        return this.time;
    }

    public String getDesc(){
        return this.desc;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    public Uri getUserImagePath(){
        return this.userImagePath;
    }

    public String getCodePath(){
        return this.codePath;
    }

    public List<String> getTags(){
        return this.tags;
    }

}
