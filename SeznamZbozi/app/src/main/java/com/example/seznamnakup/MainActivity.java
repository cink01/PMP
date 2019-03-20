package com.example.seznamnakup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i =getIntent();
        Zbozi z = (Zbozi) i.getSerializableExtra("Zbozi");
        EditText naz = (EditText)findViewById(R.id.et_nazev);
        EditText cen = (EditText)findViewById(R.id.et_cena);
        EditText poc = (EditText)findViewById(R.id.et_pocet);

        naz.setText(z.nazev);
        cen.setText(Float.toString(z.cena));
        poc.setText(Float.toString(z.pocet));
    }

    public void onClickPridej(View view){
        Intent intent = new Intent(this,PridaniActivity.class);
        startActivity(intent);
    }
}
