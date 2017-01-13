package com.example.hafizi.octranspo;

/**
 * Created by HAFIZI on 2017-01-11.
 */

import java.io.Serializable;

public class BusStop implements Serializable {
    private static final long serialVersionUID = 21L;
    String description, stopID, stopNo;
    Schedule schedule;

    public BusStop(String stopID, String stopNo, String description, Schedule schedule) {
        this.stopID = stopID;
        this.stopNo = stopNo;
        this.description = description;
        this.schedule = new Schedule();

    }

    public String getStopID(){
        return stopID;
    }

    public String toString() {
        return ("stopID : " + stopID + "\nStopNo : " + stopNo + "\nDescription : " + description);
    }
}
