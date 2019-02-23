package com.bw.Week2.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.Week2.R;
import com.bw.Week2.model.bean.Bean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyRlcAdapter
 * @package com.bw.Week2.view.adapter
 * @date 2019/2/23/023 7:51
 */
public class MyRlcAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
     Context context;
     List<Bean.ResultEntity> list;

    public MyRlcAdapter(Context context, List<Bean.ResultEntity> list) {
        this.context=context;
        this.list=list;
    }


    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1= (ViewHolder) viewHolder;
        viewHolder1.textView.setText(list.get(i).getCommodityName());
        Glide.with(context).load(list.get(i).getMasterPic()).into(viewHolder1.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text1);
            imageView = itemView.findViewById(R.id.image_item);
        }
    }



}

