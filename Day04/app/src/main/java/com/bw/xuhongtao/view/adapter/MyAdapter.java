package com.bw.xuhongtao.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.xuhongtao.R;
import com.bw.xuhongtao.ShowActivity;
import com.bw.xuhongtao.model.Bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyAdapter
 * @package com.bw.xuhongtao.view.adapter
 * @date 2019/2/15/015 20:42
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Bean.DataEntity> data;
    private int TYPE1 = 0;
    private int TYPE2 = 1;


    public MyAdapter(Context context, List<Bean.DataEntity> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {


        if (position % 2 == 0) {
            return TYPE1;
        }
        return TYPE2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int type = getItemViewType(i);
        if (type == TYPE1) {

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }
        if (type == TYPE2) {

            View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item2, null, false);
            ViewHolder1 viewHolder1 = new ViewHolder1(view1);
            return viewHolder1;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if (type == TYPE1) {
            ViewHolder viewHolder1 = (ViewHolder) viewHolder;
            viewHolder1.textView.setText(data.get(i).getTitle());

        }
        else if (type == TYPE2) {
            ViewHolder1 viewHolder2 = (ViewHolder1) viewHolder;
            viewHolder2.textView.setText(data.get(i).getTitle());
            Glide.with(context).load(data.get(i).getThumbnail_pic_s()).into(viewHolder2.imageView);

        }

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
