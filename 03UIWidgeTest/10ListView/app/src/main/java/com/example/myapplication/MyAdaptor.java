package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdaptor extends BaseAdapter {
    private List<ListData> data;
    private Context context;

    public MyAdaptor(List<ListData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int i) {
        return this.data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.list_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = view.findViewById(R.id.tv);
            view.setTag(viewHolder);
            Log.d("data", "getView: aaaaaaaaaaaa");
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(this.data.get(i).name);
        Log.d("data", "getView: " + i + view);
        return view;
    }

    private final class ViewHolder {
        TextView textView;
    }
}
