package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageRVAdaptor extends RecyclerView.Adapter<MessageRVAdaptor.MessageHolder> {

    private Context context;
    private List<String> data;

    MessageRVAdaptor(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MessageRVAdaptor.MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageHolder(LayoutInflater.from(this.context).inflate(R.layout.message_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageRVAdaptor.MessageHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MessageHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.message_item_tv);
        }
    }
}
