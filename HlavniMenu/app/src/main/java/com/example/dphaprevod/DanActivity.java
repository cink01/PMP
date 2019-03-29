package com.example.dphaprevod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dan);
    }

    public void onClickPocitej(View view){
        EditText zadan = (EditText)findViewById(R.id.editText_zadan);
        EditText sazba = (EditText)findViewById(R.id.editText_sazba);
        EditText vysl = (EditText)findViewById(R.id.editText_sDPH);
        vysl.setText(Double.toString((Float.parseFloat(zadan.getText().toString()))
                +
                ((Float.parseFloat(zadan.getText().toString()))
                        *
                        (Float.parseFloat(sazba.getText().toString())
                                /
                                100.0))));
    }
}
