package com.bw.week.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.week.R;
import com.bw.week.model.bean.SouSuoBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName Xrlv2Adapter
 * @package com.bw.week.view.adapter
 * @date 2019/3/1/001 20:24
 */
public class Xrlv2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<SouSuoBean.ResultEntity> result;
    public Xrlv2Adapter(Context context, List<SouSuoBean.ResultEntity> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.sousuopersenter, null, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder1)viewHolder).text_sousuop.setText(result.get(i).getCommodityName());
        Glide.with(context).load(result.get(i).getMasterPic()).into(((ViewHolder1)viewHolder).image_sousuop);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView image_sousuop;
        private final TextView text_sousuop;


        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            image_sousuop = itemView.findViewById(R.id.image_sousuop);
            text_sousuop = itemView.findViewById(R.id.text_sousuop);
        }
    }
}
