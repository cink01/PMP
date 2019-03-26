package com.example.seznamnakup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class PridaniActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pridani);
    }

    public void onClickProvedPridani(View view) {

        try {
            EditText nazev = findViewById(R.id.editText_nazev);
            EditText pocet = findViewById(R.id.editText_pocet);
            EditText cena = findViewById(R.id.editText_cena);
            Zbozi tmp = new Zbozi(nazev.getText().toString(), Float.parseFloat(cena.getText().toString()), Float.parseFloat(pocet.getText().toString()));
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Zbozi", tmp);
            startActivity(intent);
        } catch (Exception ex) {
            Toast.makeText(this, "Položky nesmí být prázdné", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickUkonci(View view){
        finish();
        super.onBackPressed();
    }
}