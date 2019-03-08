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
 * @fileName PzshAdapter
 * @package com.bw.week.view.adapter
 * @date 2019/3/1/001 19:55
 */
class PzshAdapter extends RecyclerView.Adapter {
    Context context;
    List<ShouYeBean.ResultEntity.PzshEntity.CommodityListEntity> pzsh;

    public PzshAdapter(Context context, List<ShouYeBean.ResultEntity.PzshEntity.CommodityListEntity> pzsh) {
        this.context = context;
        this.pzsh = pzsh;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pzsh, viewGroup, false);
        return new ViewHolder1(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder1)viewHolder).title_pzsh.setText(pzsh.get(i).getCommodityName());
        ((ViewHolder1)viewHolder).price_pzsh.setText(pzsh.get(i).getPrice()+"");
        Glide.with(context).load(pzsh.get(i).getMasterPic()).into(((ViewHolder1)viewHolder).image_pzsh);
    }

    @Override
    public int getItemCount() {
        return pzsh.size();
    }


    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView image_pzsh;
        private final TextView title_pzsh, price_pzsh;


        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            image_pzsh = itemView.findViewById(R.id.image_pzsh);
            title_pzsh = itemView.findViewById(R.id.title_pzsh);
            price_pzsh = itemView.findViewById(R.id.price_pzsh);
        }
    }
}
