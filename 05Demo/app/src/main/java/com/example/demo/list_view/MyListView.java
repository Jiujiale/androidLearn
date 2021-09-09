package com.example.demo.list_view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

public class MyListView extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);

        listView = findViewById(R.id.list_view01);

        listView.setAdapter(new MyAdaptor(MyListView.this));

        MyItemClick myItemClick = new MyItemClick();

        listView.setOnItemClickListener(myItemClick);
    }

    private class MyItemClick implements AdapterView.OnItemClickListener {

        private TextView _textView;

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            this._textView = view.findViewById(R.id.list_item_title);
            String str = this._textView.getText().toString();
            Toast.makeText(MyListView.this, str, Toast.LENGTH_SHORT).show();
        }
    }
}
