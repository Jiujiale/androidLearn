package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.fragTest2.FragStackTest;
import com.example.demo.list_view.MyListView;
import com.example.demo.my_grid_view.MyGridActivity;
import com.example.demo.my_recycler_hor.RVHorActivity;
import com.example.demo.my_recycler_view.linear_list.MyRecyclerActivity;
import com.example.demo.staggerRV.StaggerRVActivity;

public class MainActivity extends AppCompatActivity {

    private Button imageView;
    private Button listView;
    private Button gridView;
    private Button recycler_linear_view;
    private Button recycler_linear_view_hor;
    private Button recycler_linear_view_stage;
    private Button webView;
    private Button customToast;
    private Button popupBtn;
    private Button fragmentTest;
    private Button fragmentTest2;
    private Button sharedData;
    private Button fileData;
    private Button broadcast;
    private Button animationTest;
    private Button messageTest;
    private Button takePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpView();

        setUpEvent();

    }

    private void setUpView() {
        imageView = findViewById(R.id.image_view);
        listView = findViewById(R.id.list_view);
        gridView = findViewById(R.id.btn_grid_view);
        recycler_linear_view = findViewById(R.id.btn_recycler_view);
        recycler_linear_view_hor = findViewById(R.id.btn_recycler_view_hor);
        recycler_linear_view_stage = findViewById(R.id.btn_recycler_view_stag);
        webView = findViewById(R.id.btn_web_view);
        customToast = findViewById(R.id.btn_custom_toast);
        popupBtn = findViewById(R.id.btn_pop_up);
        fragmentTest = findViewById(R.id.btn_fragment);
        fragmentTest2 = findViewById(R.id.btn_fragment2);
        sharedData = findViewById(R.id.btn_shared_data);
        fileData = findViewById(R.id.btn_file_data);
        broadcast = findViewById(R.id.btn_broadcast);
        animationTest = findViewById(R.id.btn_animation);
        messageTest = findViewById(R.id.btn_message);
        takePhoto = findViewById(R.id.btn_photo);
    }

    private void setUpEvent() {
        OnClick click = new OnClick();
        imageView.setOnClickListener(click);
        listView.setOnClickListener(click);
        gridView.setOnClickListener(click);
        recycler_linear_view.setOnClickListener(click);
        recycler_linear_view_hor.setOnClickListener(click);
        recycler_linear_view_stage.setOnClickListener(click);
        webView.setOnClickListener(click);
        customToast.setOnClickListener(click);
        popupBtn.setOnClickListener(click);
        fragmentTest.setOnClickListener(click);
        fragmentTest2.setOnClickListener(click);
        sharedData.setOnClickListener(click);
        fileData.setOnClickListener(click);
        broadcast.setOnClickListener(click);
        animationTest.setOnClickListener(click);
        messageTest.setOnClickListener(click);
        takePhoto.setOnClickListener(click);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.image_view:
                    intent = new Intent(MainActivity.this, ImageViewDemo.class);
                    break;
                case R.id.list_view:
                    intent = new Intent(MainActivity.this, MyListView.class);
                    break;
                case R.id.btn_grid_view:
                    intent = new Intent(MainActivity.this, MyGridActivity.class);
                    break;
                case R.id.btn_recycler_view:
                    intent = new Intent(MainActivity.this, MyRecyclerActivity.class);
                    break;
                case R.id.btn_recycler_view_hor:
                    intent = new Intent(MainActivity.this, RVHorActivity.class);
                    break;
                case R.id.btn_recycler_view_stag:
                    intent = new Intent(MainActivity.this, StaggerRVActivity.class);
                    break;
                case R.id.btn_web_view:
                    intent = new Intent(MainActivity.this, web_view.class);
                    break;
                case R.id.btn_custom_toast:
                    intent = new Intent(MainActivity.this, ToastCustom.class);
                    break;
                case R.id.btn_pop_up:
                    intent = new Intent(MainActivity.this, PopupTest.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, FragmentTest.class);
                    break;
                case R.id.btn_fragment2:
                    intent = new Intent(MainActivity.this, FragStackTest.class);
                    break;
                case R.id.btn_shared_data:
                    intent = new Intent(MainActivity.this, SharedActivity.class);
                    break;
                case R.id.btn_file_data:
                    intent = new Intent(MainActivity.this, FileActivityTest.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadcastTest.class);
                    break;
                case R.id.btn_animation:
                    intent = new Intent(MainActivity.this, AnimationTest.class);
                    break;
                case R.id.btn_message:
                    intent = new Intent(MainActivity.this, MessageTest.class);
                    break;
                case R.id.btn_photo:
                    intent = new Intent(MainActivity.this, TaskPhoto.class);
                    break;
                default:
                    break;
            }
            if (intent != null) {
                startActivity(intent);
            }
        }
    }
}