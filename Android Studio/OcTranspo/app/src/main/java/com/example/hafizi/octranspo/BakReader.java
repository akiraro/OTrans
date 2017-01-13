package com.example.hafizi.octranspo;

/**
 * Created by HAFIZI on 2017-01-11.
 */

import android.app.Activity;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class BakReader implements Serializable{
    private static final long serialVersionUID = 21L;
    private static Activity originActivity = null;

    public BakReader(Activity activity) {
        originActivity = activity;
    }

    public Object run(String filename) {
        Object data = null;
        try {
            InputStream fis = originActivity.getResources().getAssets().open(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = ois.readObject();
            ois.close();
            System.out.println("Read completed");

        } catch (Exception e) {
            System.out.println("Error to read the file : " + filename);
            System.out.println(e);
        }
        return data;
    }
}
