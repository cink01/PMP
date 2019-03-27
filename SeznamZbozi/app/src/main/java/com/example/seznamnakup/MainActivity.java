package com.example.seznamnakup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Zbozi> zbozis = DataHolder.getInstance().zbozis;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       try {
           MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_items,menu);

        }
        catch (Exception ex) {}
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menu_pridat) {
            Intent intent = new Intent(this, PridaniActivity.class);
            startActivity(intent);

            return true;
        }
        if (id == R.id.menu_celkem) {


            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            Intent i = getIntent();
            ListView lv = findViewById(R.id.listview_seznam);
            Zbozi z = (Zbozi) i.getSerializableExtra("Zbozi");
            Zbozi x = new Zbozi(z.nazev, z.cena, z.pocet);
            zbozis.add(x);
            Refresh();
        }
        catch (Exception ex) {}
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void onClickPridej(View view) {
        Intent intent = new Intent(this, PridaniActivity.class);
        startActivity(intent);
    }

    private void Refresh() {
        lv = findViewById(R.id.listview_seznam);
        ArrayAdapter<Zbozi> arrayAdapter = new ArrayAdapter<Zbozi>(this, android.R.layout.simple_list_item_1, zbozis);
        lv.setAdapter(arrayAdapter);
    }
}