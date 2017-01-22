package com.example.hafizi.octranspo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    BusAdapter adapter;
    String[] values = new String[751];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Load load = new Load();
        load.run(this);
        Bus[] bus = load.bus;


/*
        for (int i = 0;i<750;i++){
            if (bus[i] != null) {
                values[i] = Integer.toString(bus[i].getNo());
            }
            else{
                values[i] = null;
            }
        }
*/

        final ListView listView = (ListView) findViewById(R.id.ListView);
        adapter = new BusAdapter(this,bus);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

            }

        });

    }
}
