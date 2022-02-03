package com.example.testdevmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.testdevmobile.fragments.WeatherFragments;

// implementation 'androidx.databinding:databinding-runtime:7.1.0'
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

    public void openList(View view) {
        Intent listIntent = new Intent(this, drugsList.class);
        startActivity(listIntent);
    }

    onMenuClick(){
        FragmentManager fragmentManager = getFragmentManager()
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        WeatherFragments fragment = new WeatherFragments();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}