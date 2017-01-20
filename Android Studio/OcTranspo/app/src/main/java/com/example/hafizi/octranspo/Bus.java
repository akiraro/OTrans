package com.example.hafizi.octranspo;

/**
 * Created by HAFIZI on 2017-01-11.
 */

import java.io.Serializable;

public class Bus implements Serializable {
    private static final long serialVersionUID = 1L;

    int no,direction;
    String description;
    public String[] busStop;
    public Bus(int no, int direction, String description, String[] busStop){
        this.no = no;
        this.direction = direction;
        this.description = description;
        this.busStop = busStop;

    }

    public int getNo(){	return no; }
    public int getDirection(){ return direction; }
    public String getDescription(){ return description; }
    public String toString(){
        return("\nBus Number : " + no  + "\nDirection : " + direction + "\nDescription : " + description);
    }


}
