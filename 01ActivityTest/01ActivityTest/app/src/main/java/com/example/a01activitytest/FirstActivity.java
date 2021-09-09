package com.example.a01activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("data", "First Activity Task id is " + getTaskId());
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
//                显示Intent
//                Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

//                隐式Intent
//                Intent intent = new Intent("com.example.a01activitytest.ACTION_START");
//                intent.addCategory("com.example.a01activitytest.MY_CATEGORY");

//                浏览器调用
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));

//                打电话
//                Intent intent = new Intent((Intent.ACTION_DIAL));
//                intent.setData(Uri.parse("tel:10086"));

//                传递数据
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("extra data", data);
//                startActivity(intent);

//                获取传递回来的数据
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivityForResult(intent, 1);

//                活动启动模式测试 standard
//                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
//                startActivity(intent);

//                活动启动模式测试 singleTop
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
//        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.remove_item:
                Toast.makeText(this, "Remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_item:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
//        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d("data", "requestCode:" + requestCode + "," + "resultCode:" + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == 200) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d("data", returnData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("data", "onRestart: ...");
    }
}