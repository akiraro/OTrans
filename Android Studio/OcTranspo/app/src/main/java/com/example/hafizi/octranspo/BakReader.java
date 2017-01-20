package com.example.hafizi.octranspo;

/**
 * Created by HAFIZI on 2017-01-11.
 */

import android.app.Activity;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class BakReader implements Serializable{
    private static final long serialVersionUID = 21L;
    private static Activity originActivity = null;

    public BakReader() {
    }

    public Object run(String filename) {
        Object data = null;
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = ois.readObject();
            ois.close();
            System.out.println("Read completed : " + filename);

        } catch (Exception e) {
            System.out.println("Error to read the file");
        }
        return data;
    }

}
