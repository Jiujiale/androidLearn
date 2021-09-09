package com.example.demo.my_recycler_hor;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.my_recycler_view.linear_list.LinearRVAdaptor;

public class RVHorActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rv_hor_activity);

        recyclerView = findViewById(R.id.rv_hor);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RVHorActivity.this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(RVHorActivity.this, 3);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new RVHorAdaptor(RVHorActivity.this, new RVHorAdaptor.RVItemClick() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RVHorActivity.this, "hello+ " + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
