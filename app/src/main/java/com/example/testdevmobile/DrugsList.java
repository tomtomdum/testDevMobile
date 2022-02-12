package com.example.testdevmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrugsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugs_list);

        ArrayList<String> drugList = new ArrayList<String>();
        drugList.add("tylenol");
        drugList.add("aspirine");
        drugList.add("pillule");
        drugList.add("grosse pillule");
        drugList.add("minecraft pill");
//        TextView texteprincipale = findViewById(R.id.texte1);
//        texteprincipale.setText("akki");
        ArrayAdapter drugListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , drugList);
        ListView drugListView = (ListView) findViewById(R.id.drug_List);
        createRandom(drugList);
        drugListView.setAdapter(drugListAdapter);
    }
    public void createRandom(ArrayList<String> druglist){
        for(int i =0; i<30; i++){
            druglist.add("allo"+i);
        }
    }


//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.context_menu, menu);
//    }

    public void testerino(View view) {
        Intent cam = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(cam);
    }
}