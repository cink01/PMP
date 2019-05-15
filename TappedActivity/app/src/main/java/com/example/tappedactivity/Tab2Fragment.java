package com.example.tappedactivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Tab2Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_cena,container,false);

        Button proved = (Button) view.findViewById(R.id.button_pocitej);
        proved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                try {
                    EditText cena1 = (EditText) view1.findViewById(R.id.editText_ValueCena1);
                    EditText cena2 = (EditText) view1.findViewById(R.id.editText_ValueCena2);
                    EditText vaha1 = (EditText) view1.findViewById(R.id.editText_ValueVaha1);
                    EditText vaha2 = (EditText) view1.findViewById(R.id.editText_ValueVaha2);
                    TextView porovnani = (TextView) view1.findViewById(R.id.textView_Porovnani);
                    TextView cenakg1 = (TextView) view1.findViewById(R.id.textView_CenaKg1);
                    TextView cenakg2 = (TextView) view1.findViewById(R.id.textView_CenaKg2);
                    //využití třídy zboží
                    Zbozi prvni = new Zbozi(Float.parseFloat(cena1.getText().toString()), Float.parseFloat(vaha1.getText().toString()));
                    Zbozi druhy = new Zbozi(Float.parseFloat(cena2.getText().toString()), Float.parseFloat(vaha2.getText().toString()));
                    porovnani.setText(Zbozi.Porovnej(prvni, druhy));//zavolaní statické funkce, která vrátí co je ze dou zboží levnější
                    cenakg1.setText("Cena prvního na kg je: " + prvni.toString());
                    cenakg2.setText("Cena druhého na kg je: " + druhy.toString());
                } catch (NumberFormatException e) {

                }
            }
        });
        return view;
    }

}
