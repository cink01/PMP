package com.example.sql_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    Button btnAdd,btnView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnView = (Button) findViewById(R.id.btn_View);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String newEntry = editText.getText().toString();
                    if(editText.length()!=0)
                    {
                        AddDat(newEntry);
                        editText.setText("");
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Musis neco zadat",Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
    public void AddDat(String newEntry){
        boolean insertdata = myDB.AddData(new Zbozi(newEntry, 23.2f,12f));
        if(insertdata==true)
        {
            Toast.makeText(MainActivity.this,"FINITO",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Chyba zadaní",Toast.LENGTH_LONG).show();
        }
    }

}
