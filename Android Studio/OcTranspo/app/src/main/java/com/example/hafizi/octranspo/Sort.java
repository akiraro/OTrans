package com.example.hafizi.octranspo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HAFIZI on 2017-01-13.
 */

public class Sort {

    public static void main (String[]args){

        InputOutput IO = new InputOutput();

        HashMap<String,BusStop> temp = IO.run1();

        //HashMap<String,String[]> busList = IO.run2();
        //new Save(busList, "BusList");


        //BakReader reader = new BakReader();
        //HashMap<String,String[]> busList = (HashMap<String,String[]>)reader.run("BusList.ser");
        //Bus[] Bus = IO.run3(busList);
        //new Save(Bus,"Bus");

        HashMap<String,BusStop> busStop = IO.run4(temp);
        new Save(busStop, "BusStop");

    }
}
