package com.example.seznamnakup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        try{
        Intent i =getIntent();
        ListView lv=(ListView)findViewById(R.id.listview_seznam);
        Zbozi z = (Zbozi) i.getSerializableExtra("Zbozi");
        ArrayList<Zbozi> zbozis=new ArrayList<>() ;
        zbozis.add(z);

        Refresh();

        }
        catch (Exception ex){}
        //  ArrayAdapter aa=new ArrayAdapter(R.layout.simple_list_item_l.arrayList);
       /* EditText naz = (EditText)findViewById(R.id.et_nazev);
        EditText cen = (EditText)findViewById(R.id.et_cena);
        EditText poc = (EditText)findViewById(R.id.et_pocet);*/
//https://www.youtube.com/watch?v=Mja5YoL9Jak
/*        naz.setText(z.nazev);
        cen.setText(Float.toString(z.cena));
        poc.setText(Float.toString(z.pocet));*/
    }

    public void onClickPridej(View view){
        Intent intent = new Intent(this,PridaniActivity.class);
        startActivity(intent);
    }

    private void Refresh(){}
}
