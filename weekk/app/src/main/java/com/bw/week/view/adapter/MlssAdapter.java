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
import com.bw.week.model.bean.ShouYeBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MlssAdapter
 * @package com.bw.week.view.adapter
 * @date 2019/3/1/001 19:10
 */
class MlssAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<ShouYeBean.ResultEntity.MlssEntity.CommodityListEntity> mlss;

    public MlssAdapter(Context context, List<ShouYeBean.ResultEntity.MlssEntity.CommodityListEntity> mlss) {
        this.context=context;
        this.mlss=mlss;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mlss,viewGroup,false);
        return new  ViewHolder1(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder1) viewHolder).title_mlss.setText(mlss.get(i).getCommodityName());
        ((ViewHolder1) viewHolder).price_mlss.setText(mlss.get(i).getPrice() + "");
        Glide.with(context).load(mlss.get(i).getMasterPic()).into(((ViewHolder1) viewHolder).image_mlss);

    }

    @Override
    public int getItemCount() {
        return mlss.size();
    }



    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView image_mlss;
        private final TextView title_mlss, price_mlss;


        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            image_mlss = itemView.findViewById(R.id.image_mlss);
            title_mlss = itemView.findViewById(R.id.title_mlss);
            price_mlss = itemView.findViewById(R.id.price_mlss);
        }
    }
}
