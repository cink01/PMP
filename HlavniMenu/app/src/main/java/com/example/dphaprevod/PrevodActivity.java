package com.example.dphaprevod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PrevodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevod);
    }

    public void onClickProved(View view){
        EditText zadan = (EditText)findViewById(R.id.editText_zadan);
        EditText vysl = (EditText)findViewById(R.id.editText_vysledek);
        vysl.setText(Double.toString((Float.parseFloat(zadan.getText().toString()))/1000.0));
    }
}
