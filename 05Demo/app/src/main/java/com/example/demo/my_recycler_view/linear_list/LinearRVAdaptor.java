package com.example.demo.my_recycler_view.linear_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class LinearRVAdaptor extends RecyclerView.Adapter<LinearRVAdaptor.LinearViewHolder> {

    private Context context;
    private RVItemClickListener rvlistener;

    public LinearRVAdaptor(Context context, RVItemClickListener listener) {
        this.context = context;
        this.rvlistener = listener;
    }

    @NonNull
    @Override
    public LinearRVAdaptor.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(this.context).inflate(R.layout.recycler_linear_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearRVAdaptor.LinearViewHolder holder, int position) {
        holder.textView.setText("hello recycler view" + position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvlistener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rv_title);
        }
    }

    public interface RVItemClickListener {
        void onClick(int pos);
    }
}
