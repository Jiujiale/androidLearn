package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ListData> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initData();
    }

    void initData() {
        for (int i = 0; i < 100; i ++) {
            ListData ld = new ListData(i + "");
            this.listData.add(ld);
        }

        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(new MyAdaptor(this.listData, this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("data click", "onItemClick: i: " + i + ", l: " + l);
            }
        });
    }
}