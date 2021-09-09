package com.example.demo.my_grid_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.R;

public class MyGridAdaptor extends BaseAdapter {

    private Context context;
    private LayoutInflater mlayoutInflater;
    private String flowerUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimages.quanjing.com%2Feast002%2Fhigh%2Feast-ep-a91-2812228.jpg&refer=http%3A%2F%2Fimages.quanjing.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633142010&t=8ea1d6780c9aeb0dbe2d16d8adc74460";

    MyGridAdaptor(Context context) {
        this.context = context;
        this.mlayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder {
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = this.mlayoutInflater.inflate(R.layout.grid_item, null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.grid_item_image);
            viewHolder.textView = view.findViewById(R.id.grid_item_text);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(this.context).load(this.flowerUrl).into(viewHolder.imageView);
        viewHolder.textView.setText("flower" + i);
        return view;
    }
}
