package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.et1);
        password = findViewById(R.id.et2);
        loginBtn = findViewById(R.id.btn1);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pword = password.getText().toString();
                if ("admin".equals(uname) && "123456".equals(pword)) {
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESS", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}