package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class ImageViewDemo extends AppCompatActivity {

    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        imageView = findViewById(R.id.image_view05);
        String imageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.16pic.com%2F00%2F88%2F44%2F16pic_8844212_s.jpg&refer=http%3A%2F%2Fimg.16pic.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633082883&t=bc617f756637fda78041a8ab0a77612e";
        Glide.with(this).load(imageUrl).into(imageView);
    }
}