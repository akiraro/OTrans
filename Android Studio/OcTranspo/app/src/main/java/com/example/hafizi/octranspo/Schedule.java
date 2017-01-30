package com.example.hafizi.octranspo;

/**
 * Created by HAFIZI on 2017-01-11.
 */

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Schedule implements Serializable{
    private static final long serialVersionUID = 1L;
    HashMap<String, ArrayList<Date>> data = new HashMap<String,ArrayList<Date>>();

    public void addTime(String no, String time) {
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("H:mm:ss");
            date = formatter.parse(time);
            System.out.println(date.toString());
        }
        catch(Exception b){
            System.out.println(b);
            System.out.println("Couldn't set the format for date");
        }

        try{
            ArrayList<Date> dummy = data.remove(no);
            dummy.add(date);
            data.put(no,dummy);
        }
        catch(Exception a){
            ArrayList<Date> dummy = new ArrayList<Date>();
            dummy.add(date);
            data.put(no,dummy);
        }

        /*
        try {
            String[] temp = data.remove(no);

            int i = 0;
            while (temp[i] != null) {
                i++;
            }
            temp[i] = time;
            data.put(no, temp);

        } catch (Exception e) {
            dummy[0] = time;
            data.put(no, dummy);
        }
        */


    }

    /*
    public void printTime(String no){
        String[] temp = data.get(no);
        int i = 0 ;
        while(temp[i] != null){
            System.out.println(temp[i]);
            i++;
        }
    }
    */

    public ArrayList<Date> getTime(String no){
        return data.get(no);
    }
}
