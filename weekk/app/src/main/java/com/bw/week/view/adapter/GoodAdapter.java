package com.bw.week.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.week.R;
import com.bw.week.model.bean.GoodBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName GoodAdapter
 * @package com.bw.week.view.adapter
 * @date 2019/3/2/002 11:47
 */
class GoodAdapter extends RecyclerView.Adapter {
    Context context;
    List<GoodBean.ResultEntity> result;

    public GoodAdapter(Context context, List<GoodBean.ResultEntity> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.good, null, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder1)viewHolder).text_good.setText(result.get(i).getCommodityName());
        Glide.with(context).load(result.get(i).getMasterPic()).into(((ViewHolder1)viewHolder).image_good);

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView text_good;
        private final ImageView image_good;


        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            text_good = itemView.findViewById(R.id.text_good);
            image_good = itemView.findViewById(R.id.image_good);


        }
    }
}
