package com.example.a01activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("data", "Second Activity Task id is " + getTaskId());

//        获取 activity 传递过来的数据
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra data");
//        Log.d("SecondActivity", data);

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
//                startActivity(intent);

//                传回数据给 前一个 activity
//                Intent intent = new Intent();
//                intent.putExtra("data_return", "hello I am back");
//                setResult(200, intent);
//                finish();

                //                活动启动模式测试 singleTop
//                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
//                startActivity(intent);

                //                活动启动模式测试 singleInstance
//                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
//                startActivity(intent);

//                活动传参另一种方式
                SecondActivity.actionStart(SecondActivity.this, "data1111", "data222");
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "hahaha I am back too~");
        setResult(200, intent);
        Log.d("data", "onBackPressed: ");
        finish();
        super.onBackPressed();
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, ThirdActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("data", "onDestroy: Second Activity");
    }
}