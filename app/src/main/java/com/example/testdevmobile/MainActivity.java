package com.example.testdevmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.testdevmobile.API.APIService;
import com.example.testdevmobile.API.RetrofitClient;
import com.example.testdevmobile.databinding.ActivityMainBinding;
import com.example.testdevmobile.fragments.WeatherFragments;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/*
Résumé comment faire un fragment
crééer une classe weatherfragmet
crééer une layout weatherfragement (contient le layout du fragment)
crééer une méthode qui va remplacer un élément du layout main qui va etre le container du layout weather
 */
// implementation 'androidx.databinding:databinding-runtime:7.1.0'
public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private int counter =0;
    private ActivityMainBinding binder;
    int compteur;
    final String apiKey = "1a4ccf761bb9a9b056e4c047af130474";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binder.getRoot());



        Retrofit retrofit = RetrofitClient.getClient("https://api.openweathermap.org/data/2.5/");
        APIService api = retrofit.create(APIService.class);

        Call<JsonObject> call = api.getMeteo(45,11,apiKey);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject object = response.body();
                object.get("coord");
                //parse object
                Log.i("aaa", object.get("coord").toString());
                Log.i("aaa", object.toString());

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }

    public void openCam(View view) {
        Intent cam = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(cam);
    }

    public void openList(View view) {
        Intent listIntent = new Intent(this, DrugsList.class);
        startActivity(listIntent);
    }

    public void openFragment(View view){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        WeatherFragments frag = new WeatherFragments();
        transaction.replace(R.id.main_layout,frag, "weather");
        transaction.commit();
    }

    public void openRecyclerView(View view){
        Intent intent = new Intent(this,EpicerieActivity.class);
        startActivity(intent);
    }

    public void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.context_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.options_details:
                Toast.makeText(this, "option 1 selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.options_profile:
                Toast.makeText(this, "option 2 selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }
}