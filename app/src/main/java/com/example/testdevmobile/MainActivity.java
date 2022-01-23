package com.example.testdevmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int compteur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOpen(View view) {
        Intent profileItent = new Intent(this, Profile.class);
        profileItent.putExtra("name", "bork");
        profileItent.putExtra("car", "civique");
        startActivity(profileItent);
    }

    public void openCam(View view) {
        Intent cam = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(cam);
    }

    public void additions(){

    }
}