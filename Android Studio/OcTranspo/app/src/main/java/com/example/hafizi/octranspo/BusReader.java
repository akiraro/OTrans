package com.example.hafizi.octranspo;

import android.os.Bundle;

/**
 * Created by HAFIZI on 2017-01-13.
 */

import java.io.*;
import java.util.*;

//constructor//
public class BusReader {
    Bus[] bus = new Bus[760];
    HashMap<String, BusStop> busStop;

    public BusReader(HashMap<String, BusStop> busStop) {
        this.busStop = busStop;

    }

    public Scanner y, x;

    public void openFile() {
        try {
            y = new Scanner(new File("C://Users//HAFIZI//Desktop//DATA//trips.txt"));
        } catch (Exception e) {
            System.out.println("File is not found");
        }

        try {
            x = new Scanner(new File("C://Users//HAFIZI//Desktop//DATA//stop_times.txt"));
        } catch (Exception e) {
            System.out.println("File is not found");
        }

    }

    public Bus[] readFile() {
        // get direction and description//
		/*
		 * 0-bus number 1-direction 2-trip id 3-description
		 */
        y.nextLine(); // skip first line of trips

        String[] temp = null;
        String[] temp2 = null;
        Bus tempBus = null;
        while (y.hasNextLine()) {
            temp = y.nextLine().split(",");

            // create bus class //
            int number = Integer.parseInt(temp[0].split("-")[0]);
            if (bus[number] == null) {
                tempBus = new Bus(number, Integer.parseInt(temp[4]), temp[3], null);
            } else {
                tempBus = bus[number];
            }



            while (x.hasNextLine()) {
                temp2 = x.nextLine().split(",");

                if (temp[2].equals(temp2[0])) {
                    BusStop temp3 = busStop.remove(temp2[3]);
                    temp3.schedule.addTime(temp[0].split("-")[0], temp2[2]);
                    busStop.put(temp3.getStopID(), temp3);

                    // add stop to bus class//
                    if (tempBus.busStop[Integer.parseInt(temp2[4])] == null) {
                        System.out.println("adding bus stop : " + temp2[3] + " to bus : " + number);
                        tempBus.busStop[Integer.parseInt(temp2[4])] = temp2[3];
                    }
                    else{
                        //System.out.println("Redundance of bus Stop for bus : " + number);
                    }
                }


            }
            bus[number] = tempBus;


        }
        return bus;
    }

    public void closeFile() {
        y.close();
        x.close();
    }

    public Bus[] init() {
        this.openFile();
        Bus[] temp12 = this.readFile();
        this.closeFile();
        return temp12;
    }

    public HashMap<String, BusStop> getData() {
        return busStop;
    }

}