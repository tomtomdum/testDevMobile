package com.example.testdevmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Adapter;

import com.example.testdevmobile.Models.Client;
import com.example.testdevmobile.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
private ActivityRecyclerViewBinding binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());

        List<Client> listeClient = new ArrayList<>();
        listeClient.add(new Client("bark"));
        for(int i =0; i<30; i++){
            listeClient.add(new Client("bark"+i));
        }
        ClientAdapter clientAdapter = new ClientAdapter(listeClient);
        binder.recyclerView.setAdapter(clientAdapter);
    }
}