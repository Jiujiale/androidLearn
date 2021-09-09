package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demo.my_recycler_view.linear_list.LinearRVAdaptor;

import java.util.ArrayList;
import java.util.List;

public class MessageTest extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> myData;
    private EditText editText;
    private Button btn_send;
    private MessageRVAdaptor messageRVAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_test);

        myData = new ArrayList<String>();
        myData.add("hello~");
        myData.add("hi ~");
        myData.add("what is your name?");

        editText = findViewById(R.id.message_et);
        btn_send = findViewById(R.id.message_btn_send);

        recyclerView = findViewById(R.id.message_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        messageRVAdaptor = new MessageRVAdaptor(MessageTest.this, myData);
        recyclerView.setAdapter(messageRVAdaptor);
        recyclerView.setLayoutManager(linearLayoutManager);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                if (!"".equals(str)) {
                    myData.add(str);
                    messageRVAdaptor.notifyItemInserted(myData.size() - 1);
                    recyclerView.scrollToPosition(myData.size() - 1);
                    editText.setText("");
                }
            }
        });

    }
}