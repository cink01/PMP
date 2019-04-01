package com.example.app_ukazka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button proved = (Button) findViewById(R.id.button_pocitej);
        proved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText cena1 = (EditText) findViewById(R.id.editText_ValueCena1);
                    EditText cena2 = (EditText) findViewById(R.id.editText_ValueCena2);
                    EditText vaha1 = (EditText) findViewById(R.id.editText_ValueVaha1);
                    EditText vaha2 = (EditText) findViewById(R.id.editText_ValueVaha2);
                    TextView porovnani = (TextView) findViewById(R.id.textView_Porovnani);
                    TextView cenakg1 = (TextView) findViewById(R.id.textView_CenaKg1);
                    TextView cenakg2 = (TextView) findViewById(R.id.textView_CenaKg2);
                    //využití třídy zboží
                    Zbozi prvni = new Zbozi(Float.parseFloat(cena1.getText().toString()), Float.parseFloat(vaha1.getText().toString()));
                    Zbozi druhy = new Zbozi(Float.parseFloat(cena2.getText().toString()), Float.parseFloat(vaha2.getText().toString()));
                    porovnani.setText(Zbozi.Porovnej(prvni, druhy));//zavolaní statické funkce, která vrátí co je ze dou zboží levnější
                    cenakg1.setText("Cena prvního na kg je: " + prvni.toString());
                    cenakg2.setText("Cena druhého na kg je: " + druhy.toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_num_chyba), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}