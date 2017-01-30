package com.example.hafizi.octranspo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by HAFIZI on 2017-01-22.
 */

public class ScheduleAdapter extends ArrayAdapter<Date> {
    private final Context context;
    private final ArrayList<Date> values;

    public ScheduleAdapter(Context context, ArrayList<Date> values) {
        super(context, R.layout.schedulelayout, values);
        this.context = context;
        this.values = values;
        Collections.sort(values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        java.util.Date date = values.get(position);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.schedulelayout,parent,false);
        }

        if (values.get(position) != null) {
            TextView time = (TextView) convertView.findViewById(R.id.text3);
            time.setText(formatter.format(date));
        }

        return convertView;

    }

}