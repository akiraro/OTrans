package com.example.hafizi.octranspo;

import java.util.HashMap;

/**
 * Created by HAFIZI on 2017-01-13.
 */

public class Sort {

    public static void main (String[]args){
        //Reader reader = new Reader();
        //create bus stop//
        BusStopReader busStopReader = new BusStopReader();
        HashMap<String,BusStop> busStop = busStopReader.init();



        //create bus//
        Bus[] bus = new Bus[760];
        BusReader busReader = new BusReader(busStop);
        bus = busReader.init();
        busStop = busReader.getData();
        new Save(bus, "Bus");
        //Bus[] test2 = (Bus[])reader.run("Bus.ser");
        new Save(busStop, "BusStop");
        //HashMap<String,BusStop> test = (HashMap<String,BusStop>)reader.run("BusStop.ser");
        //BusStop temp = test.get("AE080");
        //temp.schedule.getTime("92");


    }
}
