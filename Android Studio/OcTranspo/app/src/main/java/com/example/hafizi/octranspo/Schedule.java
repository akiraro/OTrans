package com.example.hafizi.octranspo;

/**
 * Created by HAFIZI on 2017-01-11.
 */

import java.util.HashMap;
import java.io.Serializable;

public class Schedule implements Serializable{
    private static final long serialVersionUID = 1L;
    HashMap<String, String[]> data = new HashMap<String, String[]>();

    public void addTime(String no, String time) {
        String[] dummy = new String[200];

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
    }

    public void getTime(String no){
        String[] temp = data.get(no);
        int i = 0 ;
        while(temp[i] != null){
            System.out.println(temp[i]);
            i++;
        }
    }
}
