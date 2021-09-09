package com.example.demo.my_grid_view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

public class MyGridActivity extends AppCompatActivity {
    private GridView gridView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_layout);

        gridView = findViewById(R.id.my_grid_view);
        gridView.setAdapter(new MyGridAdaptor(MyGridActivity.this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private TextView textView;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                this.textView = view.findViewById(R.id.grid_item_text);
                Toast.makeText(MyGridActivity.this, this.textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            private TextView textView;
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                this.textView = view.findViewById(R.id.grid_item_text);
                Toast.makeText(MyGridActivity.this,  "long:" + this.textView.getText().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
