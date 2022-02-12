package com.example.testdevmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testdevmobile.Models.ItemEpicerie;

import java.util.ArrayList;

public class EpicerieActivity extends AppCompatActivity {
    ArrayList<ItemEpicerie> listeEpicerie = new ArrayList<ItemEpicerie>();
    EpicerieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epicerie);

        populateList();

        RecyclerView recyclerView = findViewById(R.id.recycler_view_epicerie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EpicerieAdapter(this, listeEpicerie);
        recyclerView.setAdapter(adapter);
    }

    private void populateList(){
        for (int i =0; i<1000000; i++){
            listeEpicerie.add(new ItemEpicerie("pormme", "ses bons quand ses pas trop surett"));
        }
    }
}