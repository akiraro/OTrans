package com.example.hafizi.octranspo;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by HAFIZI on 2017-01-18.
 */

public class InputOutput {
    Scanner a, b, c, d;
    String[] stringArray, stringArray2;

    public HashMap<String, BusStop> run1() {
        try {
            a = new Scanner(new File("C://Users//HAFIZI//Desktop//DATA//stops.txt"));
            System.out.println("Successfully initiate file BusStop");
        } catch (Exception e) {
            System.out.println("File is not found");
        }


        HashMap<String, BusStop> data = new HashMap<String, BusStop>();

        a.nextLine();
        while (a.hasNextLine()) {
            a.useDelimiter(",");
            String[] temp = a.nextLine().split(",");
            try {
                BusStop temp2 = new BusStop(temp[0], temp[1], temp[2], null);
                data.put(temp[0], temp2);
            } catch (Exception e) {
                System.out.println("Error occured : " + e);
            }
        }
        return data;

    }


    public HashMap<String, String[]> run2() {
        HashMap<String, String[]> bus = new HashMap<String, String[]>();
        String[][] busList = new String[751][100];
        //does not consider direction


        try {
            b = new Scanner(new File("C://Users//HAFIZI//Desktop//DATA//trips.txt"));
            b.nextLine();
        } catch (Exception e) {
            System.out.println("File is not found");
        }

        while (b.hasNext()) {
            stringArray = b.nextLine().split(",");
            int number = Integer.parseInt(stringArray[0].split("-")[0]);

            if (busList[number][1] == null) {
                System.out.println("Number is " + number);
                try {
                    c = new Scanner(new File("C://Users//HAFIZI//Desktop//DATA//stop_times.txt"));
                    c.nextLine();
                } catch (Exception e) {
                    System.out.println("File is not found");
                }

                while (c.hasNext()) {
                    stringArray2 = c.nextLine().split(",");
                    if (stringArray[2].equals(stringArray2[0])) {
                        busList[number][Integer.parseInt(stringArray2[4])] = stringArray2[3];
                    }
                }

            }
        }

        for (int i = 0; i < 750; i++) {
            if (busList[i][1] != null) {
                bus.put(String.valueOf(i), busList[i]);
            }
        }
        return bus;
    }

    public Bus[] run3() {
        Bus[] bus = new Bus[760];

        try {
            a = new Scanner(new File("C://Users//HAFIZI//Desktop//DATA//trips.txt"));
        } catch (Exception e) {
            System.out.println("File is not found");
        }


        // get direction and description//
		/*
		 * 0-bus number 1-direction 2-trip id 3-description
		 */
        a.nextLine(); // skip first line of trips

        String[] temp = null;
        Bus tempBus = null;
        while (a.hasNextLine()) {
            temp = a.nextLine().split(",");

            // create bus class //
            int number = Integer.parseInt(temp[0].split("-")[0]);
            if (bus[number] == null) {
                tempBus = new Bus(number, Integer.parseInt(temp[4]), temp[3], null);
            } else {
                tempBus = bus[number];
            }

        }
        return bus;
    }


    /*
    public HashMap<String,BusStop> run3(HashMap<String,BusStop> busStop){
        HashMap<String,BusStop> data = busStop;

        try {
            d = new Scanner(new File("C://Users//HAFIZI//Desktop//DATA//stop_times.txt"));
            d.nextLine();
        } catch (Exception e) {
            System.out.println("File is not found");
        }
        while(c.hasNext()) {
            stringArray = d.nextLine().split(",");
            System.out.println(stringArray[4]);
            BusStop temp = data.get(stringArray[3]);
            temp.schedule.addTime(stringArray[2]);
            data.put(temp);
        }
    }
    */
}
