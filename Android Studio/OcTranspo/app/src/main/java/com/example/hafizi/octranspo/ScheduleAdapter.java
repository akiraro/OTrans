package com.example.hafizi.octranspo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HAFIZI on 2017-01-22.
 */

public class ScheduleAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public ScheduleAdapter(Context context, String[] values) {
        super(context, R.layout.schedulelayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.schedulelayout,parent,false);
        }

        if (values[position] != null) {
            TextView time = (TextView) convertView.findViewById(R.id.text3);
            time.setText(values[position]);
        }

        return convertView;

    }

}