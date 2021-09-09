package com.example.demo;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AnimationTest extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation_test);

        textView1 = findViewById(R.id.activity_animation_tv01);
        textView2 = findViewById(R.id.activity_animation_tv02);
        textView3 = findViewById(R.id.activity_animation_tv03);
        textView4 = findViewById(R.id.activity_animation_tv04);
        textView5 = findViewById(R.id.activity_animation_tv05);
        textView6 = findViewById(R.id.activity_animation_tv06);
        textView7 = findViewById(R.id.activity_animation_tv07);
        textView8 = findViewById(R.id.activity_animation_tv08);
        textView9 = findViewById(R.id.activity_animation_tv09);
        textView10 = findViewById(R.id.activity_animation_tv10);
        textView11 = findViewById(R.id.activity_animation_tv11);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.animate().alpha(0).setDuration(3000);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.animate().rotation(20).setDuration(3000);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView3.animate().rotationX(80).setDuration(3000);
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView4.animate().rotationBy(50).setDuration(3000);
            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView5.animate().scaleX(2).setDuration(3000);
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView6.animate().scaleY(2).setDuration(3000);
            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView7.animate().scaleXBy(3).setDuration(3000);
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView8.animate().translationX(-100).setDuration(3000);
            }
        });

        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView9.animate().translationY(100).setDuration(3000);
            }
        });

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView10.animate().translationXBy(100).setDuration(3000);
            }
        });

        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setTarget(textView11);
                objectAnimator.setDuration(1000);
                objectAnimator.setPropertyName("translationX");
                objectAnimator.setFloatValues(100, 600, 0);

//                objectAnimator.setPropertyName("alpha");
//                objectAnimator.setFloatValues(0.1f, 0.2f, 0.5f, 0, 1);
                objectAnimator.start();
            }
        });
    }
}