package com.example.hafizi.octranspo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by HAFIZI on 2017-01-22.
 */

public class StopAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final HashMap<String,BusStop> busStop;

    public StopAdapter(Context context, String[] values,HashMap<String,BusStop> busStop) {
        super(context, R.layout.schedulelayout, values);
        this.context = context;
        this.values = values;
        this.busStop = busStop;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.schedulelayout,parent,false);
        }

        if (values[position] != null) {
            TextView stopNo = (TextView) convertView.findViewById(R.id.text3);
            TextView stopID = (TextView) convertView.findViewById(R.id.texthidden);
            stopNo.setText(busStop.get(values[position]).getStopNo() + "\t" + busStop.get(values[position]).getDescription());
            stopID.setText(busStop.get(values[position]).getStopID());
        }

        return convertView;

    }

}