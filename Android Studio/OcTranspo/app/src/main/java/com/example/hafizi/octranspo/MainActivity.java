package com.example.hafizi.octranspo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reader reader = new Reader(this);
        Bus[] test2 = (Bus[])reader.run("Bus.ser");
        HashMap<String,BusStop> test = (HashMap<String,BusStop>)reader.run("BusStop.ser");
        //BusStop temp = test.get("AE080");
        //temp.schedule.getTime("92");

    }
}