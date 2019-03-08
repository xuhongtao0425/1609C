package com.bw.week.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.week.R;
import com.bw.week.model.bean.Bean;
import com.bw.week.model.bean.ShouYeBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyXrlvAdapter
 * @package com.bw.week.view.adapter
 * @date 2019/3/1/001 8:24
 */
public class MyXrlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private Bean list;
    private int TYPE = 0;
    private int TYPE1 = 1;
    private int TYPE2 = 2;

    public MyXrlvAdapter(Context context,Bean list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getItemViewType(int position) {
        Log.i("position",position+"");

        if (position == 0) {
            return TYPE;
        } else if (position == 1) {
            return TYPE1;
        } else {
            return TYPE2;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == TYPE) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vh, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        } else if (i == TYPE1) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vh1, null, false);
            ViewHolder1 viewHolder1 = new ViewHolder1(view);
            return viewHolder1;
        } else {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vh2, null, false);
            ViewHolder2 viewHolder2 = new ViewHolder2(view);
            return viewHolder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            ((ViewHolder) viewHolder).title_vh.setText(list.getRxxp().getName());
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((ViewHolder) viewHolder).rlv_vh.setLayoutManager(layoutManager);
            List<ShouYeBean.ResultEntity.RxxpEntity.CommodityListEntity> commodityList = list.getRxxp().getCommodityList();
            ((ViewHolder) viewHolder).rlv_vh.setAdapter(new RxxpAdapter(context, commodityList));
        } else if (viewHolder instanceof ViewHolder1) {
            ((ViewHolder1) viewHolder).title_vh1.setText(list.getMlss().getName());
            LinearLayoutManager layoutManager1 = new LinearLayoutManager(context);
            ((ViewHolder1) viewHolder).rlv_vh1.setLayoutManager(layoutManager1);
            List<ShouYeBean.ResultEntity.MlssEntity.CommodityListEntity> mlss = list.getMlss().getCommodityList();
            Log.i("xxxxx",mlss.toString());
            ((ViewHolder1) viewHolder).rlv_vh1.setAdapter(new MlssAdapter(context,mlss));

        } else {
            ((ViewHolder2) viewHolder).title_vh2.setText(list.getPzsh().getName());
            GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
            ((ViewHolder2) viewHolder).rlv_vh2.setLayoutManager(gridLayoutManager);
            List<ShouYeBean.ResultEntity.PzshEntity.CommodityListEntity> pzsh = list.getPzsh().getCommodityList();
//            Log.i("xxxxx",mlss.toString());
            ((ViewHolder2) viewHolder).rlv_vh2.setAdapter(new PzshAdapter(context,pzsh));
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final RecyclerView rlv_vh;
        private final TextView title_vh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rlv_vh = itemView.findViewById(R.id.rlv_vh);
            title_vh = itemView.findViewById(R.id.title_vh);

        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final RecyclerView rlv_vh1;
        private final TextView title_vh1;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            rlv_vh1 = itemView.findViewById(R.id.rlv_vh1);
            title_vh1 = itemView.findViewById(R.id.title_vh1);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        private final RecyclerView rlv_vh2;
        private final TextView title_vh2;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            rlv_vh2 = itemView.findViewById(R.id.rlv_vh2);
            title_vh2 = itemView.findViewById(R.id.title_vh2);
        }
    }
}
