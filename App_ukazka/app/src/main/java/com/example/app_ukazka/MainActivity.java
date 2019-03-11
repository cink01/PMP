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

        Button proved=(Button)findViewById(R.id.button_pocitej);
        proved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try
                    {
                        EditText cena1=(EditText)findViewById(R.id.editText_ValueCena1);
                        EditText cena2=(EditText)findViewById(R.id.editText_ValueCena2);
                        EditText vaha1=(EditText)findViewById(R.id.editText_ValueVaha1);
                        EditText vaha2=(EditText)findViewById(R.id.editText_ValueVaha2);
                        TextView porovnani=(TextView)findViewById(R.id.textView_Porovnani);
                        TextView cenakg1=(TextView)findViewById(R.id.textView_CenaKg1);
                        TextView cenakg2=(TextView)findViewById(R.id.textView_CenaKg2);

                        //využití třídy zboží
                        Zbozi prvni = new Zbozi(Float.parseFloat(cena1.getText().toString()),Float.parseFloat(vaha1.getText().toString()));
                        Zbozi druhy = new Zbozi(Float.parseFloat(cena2.getText().toString()),Float.parseFloat(vaha2.getText().toString()));
                        porovnani.setText(Zbozi.Porovnej(prvni,druhy));
                        cenakg1.setText("Cena prvního na kg je: "+prvni.toString());
                        cenakg2.setText("Cena druhého na kg je: "+druhy.toString());
                      /*
                        float c1=Float.parseFloat(cena1.getText().toString());
                        float c2=Float.parseFloat(cena2.getText().toString());
                        float v1=Float.parseFloat(vaha1.getText().toString());
                        float v2=Float.parseFloat(vaha2.getText().toString());
                        float x1=(1000*c1)/v1;
                        float x2=(1000*c2)/v2;
                        cenakg1.setText("Cena prvního na kg je: "+ Float.toString(x1));
                        cenakg2.setText("Cena druhého na kg je: "+ Float.toString(x2));
                        if(x1>x2)
                        {
                            porovnani.setText("První je levnější");
                        }
                        else
                        {
                            porovnani.setText("Druhý je levnější");
                        }*/
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getApplicationContext(),getString(R.string.toast_num_chyba),Toast.LENGTH_LONG).show();
                    }

            }
        });
    }

}

