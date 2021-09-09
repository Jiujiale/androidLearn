package com.example.demo.staggerRV;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.demo.R;

public class StaggerAdaptor extends RecyclerView.Adapter<StaggerAdaptor.StaggerHolder> {

    private String flowerUrl = "https://img1.baidu.com/it/u=3044261220,3500389775&fm=26&fmt=auto&gp=0.jpg";
    private String personUrl = "https://img1.baidu.com/it/u=4001267528,3894074103&fm=11&fmt=auto&gp=0.jpg";

    private Context context;

    private STClickListener mlistener;

    StaggerAdaptor(Context context, STClickListener listener) {
        this.context = context;
        this.mlistener = listener;
    }

    @NonNull
    @Override
    public StaggerAdaptor.StaggerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StaggerHolder(LayoutInflater.from(this.context).inflate(R.layout.rv_stagger_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggerAdaptor.StaggerHolder holder, int position) {
        if ((position % 2) == 0) {
            holder.imageView.getLayoutParams().height = dpToPx(100 ,this.context);
            Glide.with(this.context).load(this.flowerUrl).into(holder.imageView);
            holder.textView.setText("flower" + position);
        } else {
            holder.imageView.getLayoutParams().height = dpToPx(250 ,this.context);
            Glide.with(this.context).load(this.personUrl).into(holder.imageView);
            holder.textView.setText("person" + position);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("clickData", "onClick: 222222");
                mlistener.onClick(position);
            }
        });
    }

    public static int dpToPx(int dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public interface STClickListener {
        public void onClick(int position);
    }

    @Override
    public int getItemCount() {
        return 200;
    }

    class StaggerHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public StaggerHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.rv_stagger_item_image_view);
            this.textView = itemView.findViewById(R.id.rv_stagger_item_text_view);
        }
    }
}
