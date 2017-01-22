package com.example.hafizi.octranspo;

import android.app.Activity;

import java.util.HashMap;

/**
 * Created by HAFIZI on 2017-01-18.
 */

public class Load {
    Bus[] bus;
    HashMap<String,BusStop> busStop;
    public void run(Activity activity) {
        Reader reader = new Reader(activity);
        bus = (Bus[]) reader.run("Bus.ser");
        busStop = (HashMap<String,BusStop>)reader.run("BusStop.ser");
    }
}
