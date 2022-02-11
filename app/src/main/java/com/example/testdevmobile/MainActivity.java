package com.example.testdevmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.testdevmobile.databinding.ActivityMainBinding;
import com.example.testdevmobile.fragments.WeatherFragments;
/*
Résumé comment faire un fragment
crééer une classe weatherfragmet
crééer une layout weatherfragement (contient le layout du fragment)
crééer une méthode qui va remplacer un élément du layout main qui va etre le container du layout weather
 */
// implementation 'androidx.databinding:databinding-runtime:7.1.0'
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binder;
    int compteur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binder.getRoot());
    }

//    public void onOpen(View view) {
//        Intent profileItent = new Intent(this, Profile.class);
//        profileItent.setAction(Intent.)
//        profileItent.putExtra("name", "bork");
//        profileItent.putExtra("car", "civique");
//        startActivity(profileItent);
//    }

    public void openCam(View view) {
        Intent cam = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(cam);
    }

    public void openList(View view) {
        Intent listIntent = new Intent(this, drugsList.class);
        startActivity(listIntent);
    }

    public void onMenuClick(View view){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        WeatherFragments frag = new WeatherFragments();
        transaction.replace(R.id.my_frag,frag, "weather");
        transaction.commit();


    }
}