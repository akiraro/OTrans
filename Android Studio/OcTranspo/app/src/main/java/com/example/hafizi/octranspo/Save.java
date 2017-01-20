package com.example.hafizi.octranspo;

/**
 * Created by HAFIZI on 2017-01-13.
 */

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Save {
    Object data;
    String filename;
    public Save(Object obj, String filename){
        this.filename = filename;
        data = obj;
        run();
    }
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename+".ser"));
            out.writeObject(data);
            out.close();
            System.out.println("\nSaved : " + filename + ".ser");
        } catch (Exception e) {
            System.out.println("Fail to save data : " + e );
        }
    }
}
