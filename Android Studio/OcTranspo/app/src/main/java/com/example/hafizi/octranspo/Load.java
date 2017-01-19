package com.example.hafizi.octranspo;

import android.app.Activity;

import java.util.HashMap;

/**
 * Created by HAFIZI on 2017-01-18.
 */

public class Load {

    public void run(Activity activity) {
        Reader reader = new Reader(activity);
        Bus[] test2 = (Bus[]) reader.run("Bus.ser");
        HashMap<String,BusStop> test = (HashMap<String,BusStop>)reader.run("BusStop.ser");
        BusStop temp = test.get("AL060");
        temp.schedule.getTime("114");
    }
}
