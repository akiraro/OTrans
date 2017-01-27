package com.example.hafizi.octranspo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by HAFIZI on 2017-01-18.
 */

public class InputOutput {
    Scanner a, b, c, d;
    String[] stringArray, stringArray2;


    // create hashmap of BusStop class
    public HashMap<String, BusStop> run1() {
        try {
            a = new Scanner(new File("//Users//HAFIZI//Desktop//DATA//stops.txt"));
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
        System.out.println("Run 1 completed : Hashmap of BusStop class created");
        return data;

    }

    //create sequences of BusStop for each of Bus
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
                        busList[number][Integer.parseInt(stringArray2[4])-1] = stringArray2[3];
                    }
                }

            }
        }

        for (int i = 0; i < 750; i++) {
            if (busList[i][1] != null) {
                bus.put(String.valueOf(i), busList[i]);
            }
        }
        System.out.println("Run 2 completed : Sequences of BusStop class created");
        return bus;
    }

    // create ArrayList of Bus
    public Bus[] run3(HashMap<String, String[]> busList) {
        Bus[] bus = new Bus[760];
        ArrayList<Bus> data = new ArrayList<Bus>() ;
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

        Bus tempBus = null;
        while (a.hasNextLine()) {
            stringArray = a.nextLine().split(",");
            // create bus class //
            int number = Integer.parseInt(stringArray[0].split("-")[0]);
            if (bus[number] == null) {
                tempBus = new Bus(number, Integer.parseInt(stringArray[4]), stringArray[3], busList.get(Integer.toString(number)));
                bus[number] = tempBus;
            } else {
                tempBus = bus[number];
            }
        }
        System.out.println("Run 3 completed : Arraylist of Bus class created");
        return bus;
    }


    // Sort "Stop_times.txt" into BusStop class
    public HashMap<String, BusStop> run4(HashMap<String, BusStop> busStop) {
        HashMap<String, BusStop> data = busStop;
        int counter = 0;

        try {
            a = new Scanner(new File("//Users//HAFIZI//Desktop//DATA//trips.txt"));
            a.nextLine();
        } catch (Exception e) {
            System.out.println("File is not found");
        }

        try {
            b = new Scanner(new File("//Users//HAFIZI//Desktop//DATA//stop_times.txt"));
            b.nextLine();
        } catch (Exception e) {
            System.out.println("File is not found");
        }

        stringArray2 = b.nextLine().split(",");
        while (a.hasNext()) {
            stringArray = a.nextLine().split(",");

            while (stringArray[2].equals(stringArray2[0])) {
                int number = Integer.parseInt(stringArray[0].split("-")[0]);
                BusStop temp = data.get(stringArray2[3]);
                temp.schedule.addTime(Integer.toString(number), stringArray2[2]);
                data.put(temp.getStopID(), temp);
                System.out.println("Adding time : " + stringArray2[2] + " to BusStop : " + temp.getStopID());
                try {
                    stringArray2 = b.nextLine().split(",");
                }
                catch(Exception e){
                    System.out.println("last line");
                    break;
                }
            }

        }

        System.out.println("Run 4 completed : Stop_times have been sorted");
        return data;
    }


}
