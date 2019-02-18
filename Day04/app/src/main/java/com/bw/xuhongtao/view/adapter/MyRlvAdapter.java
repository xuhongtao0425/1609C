package com.bw.xuhongtao.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.xuhongtao.R;
import com.bw.xuhongtao.ZhanshiActivity;
import com.bw.xuhongtao.model.Bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyRlvAdapter
 * @package com.bw.xuhongtao.view.adapter
 * @date 2019/2/17/017 17:06
 */
public class MyRlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataEntity> data;
    int TYPE = 0;
    int TYPT1 = 1;

    public MyRlvAdapter(Context context, List<Bean.DataEntity> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE;
        } else {
            return TYPT1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(TYPT1==i){
            View view=View.inflate(context, R.layout.item3,null);
            MyViewHolder myViewHolder=new MyViewHolder(view);
            return myViewHolder;
        }else if(TYPE==i){
            View view=View.inflate(context,R.layout.item4,null);
            MyViewHolder1 myViewHolder1=new MyViewHolder1(view);
            return  myViewHolder1;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if(type==TYPT1){
            MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
            myViewHolder.textView.setText(data.get(i).getTitle());
            Glide.with(context).load(data.get(i).getThumbnail_pic_s()).into(myViewHolder.image);
        }else if(type==TYPE){
            MyViewHolder1 myViewHolder1= (MyViewHolder1) viewHolder;
            myViewHolder1.textView.setText(data.get(i).getTitle());
            Glide.with(context).load(data.get(i).getThumbnail_pic_s()).into(myViewHolder1.image);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item3);
            image = itemView.findViewById(R.id.image_item3);
        }
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView image;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item4);
            image = itemView.findViewById(R.id.image_item4);
        }
    }
}
