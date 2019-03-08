package com.bw.Week2.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.Week2.R;
import com.bw.Week2.model.bean.Bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyXrlvAdapter
 * @package com.bw.Week2.view.adapter
 * @date 2019/2/23/023 12:02
 */
public class MyXrlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.ResultEntity> list;
    int TYPE = 0;
    int TYPE1 = 1;

    public MyXrlvAdapter(Context context, List<Bean.ResultEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE;
        }
        return TYPE1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        if (i == TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.item1, null, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        } else {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item2, null, false);
            ViewHolder1 viewHolder1 = new ViewHolder1(view1);
            return viewHolder1;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int type = getItemViewType(i);
        if (type == TYPE) {
            ViewHolder v = (ViewHolder) viewHolder;
            Glide.with(context).load(list.get(i).getMasterPic()).into(v.imageView);
        } else {

            ViewHolder1 vh = (ViewHolder1) viewHolder;
            vh.textView.setText(list.get(i).getCommodityName());
            Glide.with(context).load(list.get(i).getMasterPic()).into(vh.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_item1);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_item2);
            textView = itemView.findViewById(R.id.text_item2);
        }
    }
}
