package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PopupTest extends AppCompatActivity {

    private Button btn_popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_test);

        btn_popup = findViewById(R.id.show_popup);

        btn_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = getLayoutInflater().inflate(R.layout.custom_popup, null);
                TextView tv1 = view1.findViewById(R.id.pop_tv1);
                TextView tv2 = view1.findViewById(R.id.pop_tv2);
                TextView tv3 = view1.findViewById(R.id.pop_tv3);

                PopupWindow popupWindow = new PopupWindow(view1, btn_popup.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(btn_popup);

                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(PopupTest.this, "GOOD", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });

                tv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(PopupTest.this, "BETTER", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });

                tv3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(PopupTest.this, "BAD", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }
}