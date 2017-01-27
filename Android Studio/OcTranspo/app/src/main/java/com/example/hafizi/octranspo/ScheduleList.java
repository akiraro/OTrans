package com.example.hafizi.octranspo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.HashMap;

public class ScheduleList extends AppCompatActivity {
    ScheduleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_schedule);

        Load load = new Load();
        load.run(this);
        HashMap<String,BusStop> busStop = load.busStop;

        String position = getIntent().getExtras().getString("busNo");
        String stopID = getIntent().getExtras().getString("stopID");
        String[] data = busStop.get(stopID).schedule.getTime(position);
        System.out.println("busNo : " + position + " stopID : " + stopID );
        System.out.println(data[1]);

        final ListView listView = (ListView) findViewById(R.id.listView3);
        adapter = new ScheduleAdapter(this,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

            }

        });

    }

}
