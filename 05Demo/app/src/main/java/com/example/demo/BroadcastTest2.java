package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastTest2 extends AppCompatActivity {

    private Button btn_send_broadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test2);

        btn_send_broadcast = findViewById(R.id.activity_broadcast2_btn_send);

        btn_send_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.demo.update");
                LocalBroadcastManager.getInstance(BroadcastTest2.this).sendBroadcast(intent);
            }
        });
    }
}