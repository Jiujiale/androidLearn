package com.example.demo.my_recycler_hor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class RVHorAdaptor extends RecyclerView.Adapter<RVHorAdaptor.RVHorHolder> {

    private Context context;
    private RVItemClick mListener;

    RVHorAdaptor(Context context, RVItemClick listener) {
        this.context = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RVHorAdaptor.RVHorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RVHorHolder(LayoutInflater.from(this.context).inflate(R.layout.rv_hor_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVHorAdaptor.RVHorHolder holder, int position) {
        holder.textView.setText("hello" + position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 300;
    }

    class RVHorHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public RVHorHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.rv_hor_item_text_view);
        }
    }

    public interface RVItemClick {
        public void onClick(int pos);
    }
}
