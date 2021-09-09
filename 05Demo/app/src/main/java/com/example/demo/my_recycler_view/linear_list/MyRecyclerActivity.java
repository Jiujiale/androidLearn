package com.example.demo.my_recycler_view.linear_list;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class MyRecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_linear);

        recyclerView = findViewById(R.id.recycler_linear_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyRecyclerActivity.this));
        recyclerView.setAdapter(new LinearRVAdaptor(MyRecyclerActivity.this, new LinearRVAdaptor.RVItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(MyRecyclerActivity.this, "hello world" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
        recyclerView.addItemDecoration(new MyDecoration());
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0, getResources().getDimensionPixelOffset(R.dimen.divider_height));
        }

        @Override
        public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
            Log.d("rv", "onDrawOver: ");
        }
    }
}
