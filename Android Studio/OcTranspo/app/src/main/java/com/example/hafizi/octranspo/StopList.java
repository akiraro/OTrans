package com.example.hafizi.octranspo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class StopList extends AppCompatActivity {
    StopAdapter adapter;
    public int busNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_list);

        Load load = new Load();
        load.run(this);

        HashMap<String,String[]> busList = load.busList;
        busNo = Integer.parseInt(getIntent().getExtras().getString("busNo"));

        HashMap<String,BusStop> busStop = load.busStop;
        String[] data = busList.get(Integer.toString(busNo));

        final ListView listView = (ListView) findViewById(R.id.listView2);
        adapter = new StopAdapter(this,data,busStop);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Intent intent = new Intent (getApplicationContext(),ScheduleList.class);
                String stopID = ((TextView)view.findViewById(R.id.texthidden)).getText().toString();
                intent.putExtra("busNo",Integer.toString(busNo));
                intent.putExtra("stopID",stopID);
                startActivityForResult(intent,999);
            }

        });


    }
}
