package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button button = findViewById(R.id.button_02);

        // button 事件还可以在xml 中声明，然后在这里实现
        
        // 单击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: 单击事件");
            }
        });
        
        // 长按事件
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLongClick: 长按事件");
                return false;
            }
        });
        
        // 触摸事件
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d(TAG, "onTouch: 触摸事件");
                return false;
            }
        });
    }

    // 会被 id 事件覆盖
    public void btnClick(View view) {
        Log.d(TAG, "btnClick: 自定义");
    }
}