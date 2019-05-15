package com.example.tappedactivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Tab1Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_dph, container, false);

        Button bt_vypocti = (Button) view.findViewById(R.id.bt_vypocti);
        bt_vypocti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText zadan = (EditText) view.findViewById(R.id.editText_zadan);
                EditText sazba = (EditText) view.findViewById(R.id.editText_sazba);
                EditText vysl = (EditText) view.findViewById(R.id.editText_sDPH);
                vysl.setText(Double.toString((Float.parseFloat(zadan.getText().toString()))
                        +
                        ((Float.parseFloat(zadan.getText().toString()))
                                *
                                (Float.parseFloat(sazba.getText().toString())
                                        /
                                        100.0))));
            }
        });
        return view;
    }
}
