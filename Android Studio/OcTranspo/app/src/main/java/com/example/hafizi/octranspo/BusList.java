package com.example.hafizi.octranspo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BusList extends AppCompatActivity {
    BusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);

        Bus[] bus = MainActivity.bus;

        ArrayList<Bus> list = new ArrayList<Bus>();
        for(Bus a : bus){
            if(a != null){
                list.add(a);
            }
        }

        final ListView listView = (ListView) findViewById(R.id.ListView);
        adapter = new BusAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Intent intent = new Intent (getApplicationContext(),StopList.class);
                String busNo = ((TextView)view.findViewById(R.id.text1)).getText().toString();
                intent.putExtra("busNo",busNo);
                startActivityForResult(intent,262);

            }

        });

    }

}
