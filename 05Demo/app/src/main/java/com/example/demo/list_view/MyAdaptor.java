package com.example.demo.list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.R;

public class MyAdaptor extends BaseAdapter {

    private String url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.16pic.com%2F00%2F88%2F44%2F16pic_8844212_s.jpg&refer=http%3A%2F%2Fimg.16pic.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633082883&t=bc617f756637fda78041a8ab0a77612e";

    private Context context;
    private LayoutInflater mLayoutFlater;

    MyAdaptor(Context context) {
        this.context = context;
        this.mLayoutFlater = LayoutInflater.from(context);
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

    private static class ViewHolder {
        // 图片
        public ImageView iv;
        // 标题
        public TextView title;
        // 副标题
        public TextView subTitle;
        // 时间
        public TextView time;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = this.mLayoutFlater.inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder();

            viewHolder.iv = view.findViewById(R.id.list_item_image_view);
            viewHolder.title = view.findViewById(R.id.list_item_title);
            viewHolder.subTitle = view.findViewById(R.id.list_item_sub_title);
            viewHolder.time = view.findViewById(R.id.list_item_time);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.title.setText("this is title" + " : " + i);
        viewHolder.subTitle.setText("this is subTitle" + " : " + i);
        viewHolder.time.setText("2020-01-01 11:22:33" + " : " + i);
        Glide.with(this.context).load(this.url).into(viewHolder.iv);
        return view;
    }
}
