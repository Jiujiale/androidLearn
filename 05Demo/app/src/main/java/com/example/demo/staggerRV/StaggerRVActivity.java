package com.example.demo.staggerRV;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.demo.R;

public class StaggerRVActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rv_stagger_activity);

        this.recyclerView = findViewById(R.id.rv_stagger_main);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
        this.recyclerView.setAdapter(new StaggerAdaptor(StaggerRVActivity.this, new StaggerAdaptor.STClickListener() {
            @Override
            public void onClick(int position) {
                Log.d("clickData", "onClick: 111111");
                Toast.makeText(StaggerRVActivity.this, "hello" + position, Toast.LENGTH_SHORT).show();
            }
        }));
        this.recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }
}
