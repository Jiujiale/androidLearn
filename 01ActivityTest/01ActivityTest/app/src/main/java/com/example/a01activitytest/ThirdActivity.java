package com.example.a01activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d("data", "Third Activity Task id is " + getTaskId());

        Intent intent = getIntent();
        String data1 = intent.getStringExtra("param1");
        String data2 = intent.getStringExtra("param2");
        Log.d("data", "onCreate: " + data1 + data2);

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.finishAll();
    }
}