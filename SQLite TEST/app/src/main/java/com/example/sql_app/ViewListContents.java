package com.example.sql_app;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        ListView listView = (ListView) findViewById(R.id.listView);

        myDB = new DatabaseHelper(this);

        ArrayList<String/*Zbozi*/> list = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if(data.getCount()==0){
            Toast.makeText(this,"prazdna db",Toast.LENGTH_LONG).show();
        }
        else{
            while(data.moveToNext()){
                list.add(data.getString(1));  //(/*new Zbozi(*/data.getString(1)/*,data.getFloat(2),0)*/);
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
                listView.setAdapter(listAdapter);
            }

        }

    }
}
