package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastCustom extends AppCompatActivity {

    private Button normalToast;
    private Button imageToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_cutom);

        normalToast = findViewById(R.id.toast_btn01);
        imageToast = findViewById(R.id.toast_btn02);

        setUpEvents();

    }

    private void setUpEvents() {
        normalToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToastCustom.this, "Normal Context!", Toast.LENGTH_SHORT).show();
            }
        });

        imageToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View tview = getLayoutInflater().inflate(R.layout.image_toast, findViewById(R.id.image_toast_bg));
                Toast toast = new Toast(ToastCustom.this);
                toast.setView(tview);
                toast.show();
            }
        });


    }
}