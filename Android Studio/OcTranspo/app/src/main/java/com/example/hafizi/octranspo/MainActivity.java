package com.example.hafizi.octranspo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    BusAdapter adapter;
    Reader reader = new Reader(this);
    public static HashMap<String,BusStop> busStop;
    public static HashMap<String,String[]> busList;
    public static Bus[] bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        busStop = (HashMap<String,BusStop>)reader.run("BusStop.ser");
        busList = (HashMap<String,String[]>)reader.run("BusList.ser");
        bus = (Bus[]) reader.run("Bus.ser");
    }


    public void OpenRoute(View v){
        Intent intent = new Intent(this, BusList.class);
        startActivity(intent);
    }
}
