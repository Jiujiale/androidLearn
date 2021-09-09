package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedActivity extends AppCompatActivity {

    private EditText editText;
    private Button saveBtn;
    private Button showBtn;
    private TextView textView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        editText = findViewById(R.id.shared_activity_ed01);
        saveBtn = findViewById(R.id.shared_activity_btn_save);
        showBtn = findViewById(R.id.shared_activity_btn_show);
        textView = findViewById(R.id.shared_activity_tv_01);

        sharedPreferences = getSharedPreferences("myData", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                editor.putString("name", str);
                editor.apply();
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = sharedPreferences.getString("name", "placeholder text");
                textView.setText(str);
            }
        });
    }
}