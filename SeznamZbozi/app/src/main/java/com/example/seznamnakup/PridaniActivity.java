package com.example.seznamnakup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PridaniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pridani);
    }

    public void onClickProvedPridani(View view){

        EditText nazev = (EditText)findViewById(R.id.editText_nazev);
        EditText pocet = (EditText)findViewById(R.id.editText_pocet);
        EditText cena = (EditText)findViewById(R.id.editText_cena);
        Zbozi tmp=new Zbozi(nazev.getText().toString(),Float.parseFloat(cena.getText().toString()),Float.parseFloat(pocet.getText().toString()));
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("Zbozi",tmp);
        startActivity(intent);
    }
}
