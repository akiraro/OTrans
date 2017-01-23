package com.example.hafizi.octranspo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HAFIZI on 2017-01-20.
 */

public class BusAdapter extends ArrayAdapter<Bus> {
    private final Context context;
    private final ArrayList<Bus>  values;

    public BusAdapter(Context context, ArrayList<Bus> values) {
        super(context, R.layout.buslayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.buslayout,parent,false);
        }

        if (values.get(position) != null) {
            TextView busNo = (TextView) convertView.findViewById(R.id.text1);
            TextView description = (TextView) convertView.findViewById(R.id.text2);
            busNo.setText(Integer.toString(values.get(position).getNo()));
            description.setText(values.get(position).getDescription());
        }

        return convertView;

    }

}


