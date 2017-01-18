package com.example.hafizi.octranspo;

import android.app.Activity;

/**
 * Created by HAFIZI on 2017-01-18.
 */

public class Load {

    public void run(Activity activity) {
        BakReader reader = new BakReader(activity);
        Bus[] test2 = (Bus[]) reader.run("Bus.ser");
        //HashMap<String,BusStop> test = (HashMap<String,BusStop>)reader.run("BusStop.ser");
        //BusStop temp = test.get("AE080");
        //temp.schedule.getTime("92");
    }
}
