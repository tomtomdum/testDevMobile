package com.example.testdevmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testdevmobile.Models.ItemEpicerie;
import com.example.testdevmobile.databinding.ActivityEpicerieBinding;

import java.util.ArrayList;

public class EpicerieActivity extends AppCompatActivity {
    ArrayList<ItemEpicerie> listeEpicerie = new ArrayList<ItemEpicerie>();
    EpicerieAdapter adapter;
    private ActivityEpicerieBinding binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this,R.layout.activity_epicerie);
        setContentView(binder.getRoot());

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