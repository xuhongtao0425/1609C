package com.bw.week.view.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.PrecomputedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.week.R;
import com.bw.week.model.bean.ShouYeBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName RxxpAdapter
 * @package com.bw.week.view.adapter
 * @date 2019/3/1/001 13:47
 */
class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder1> {
    Context context;
    List<ShouYeBean.ResultEntity.RxxpEntity.CommodityListEntity> commodityList;

    public RxxpAdapter(Context context, List<ShouYeBean.ResultEntity.RxxpEntity.CommodityListEntity> commodityList) {
        this.commodityList = commodityList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
          View  view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rxxp,viewGroup,false);
        return new  ViewHolder1(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, int i) {
        viewHolder1.title_vh.setText(commodityList.get(i).getCommodityName());
        viewHolder1.price_vh.setText(commodityList.get(i).getPrice()+"");
         Glide.with(context).load(commodityList.get(i).getMasterPic()).into(viewHolder1.image_rxxp);
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView image_rxxp;
        private final TextView title_vh, price_vh;


        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            image_rxxp = itemView.findViewById(R.id.image_rxxp);
            title_vh = itemView.findViewById(R.id.title_vh);
            price_vh = itemView.findViewById(R.id.price_vh);
        }
    }
}
