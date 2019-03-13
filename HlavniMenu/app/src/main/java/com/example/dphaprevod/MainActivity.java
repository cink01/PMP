package com.example.dphaprevod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void onClickBtDPH(View view){
        Intent intent = new Intent(this,DanActivity.class);
        startActivity(intent);
    }
    public void onClickBtPrevod(View view){
        Intent intent = new Intent(this,PrevodActivity.class);
        startActivity(intent);
    }
}
