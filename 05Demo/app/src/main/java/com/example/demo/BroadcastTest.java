package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo.util.MyUtil;

public class BroadcastTest extends AppCompatActivity {

    private Button btn_next;
    public TextView textView;
    private MyBroadcast myBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);

        btn_next = findViewById(R.id.activity_broadcast_btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BroadcastTest.this, BroadcastTest2.class);
                startActivity(intent);
            }
        });

        textView = findViewById(R.id.activity_broadcast_tv01);

        myBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.demo.update");
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcast, intentFilter);
    }

    private class MyBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.example.demo.update".equals(intent.getAction())) {
                textView.setText("broadcast received" + MyUtil.randomInt(100, 0));
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcast);
    }
}