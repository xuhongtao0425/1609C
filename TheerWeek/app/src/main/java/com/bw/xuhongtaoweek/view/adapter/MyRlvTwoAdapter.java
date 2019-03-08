package com.bw.xuhongtaoweek.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.bean.GoodsClssBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyRlvTwoAdapter
 * @package com.bw.xuhongtaoweek.view.adapter
 * @date 2019/3/7/007 15:10
 */
public class MyRlvTwoAdapter extends RecyclerView.Adapter {
    Context context;
    List<GoodsClssBean.DataEntity> data;

    public MyRlvTwoAdapter(Context context, List<GoodsClssBean.DataEntity> data) {
        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.classifytwoitem, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder)viewHolder).title.setText(data.get(i).getName());
        //布局管理器
        GridLayoutManager layoutManager=new GridLayoutManager(context,3);
        ((ViewHolder)viewHolder).rlv.setLayoutManager(layoutManager);
        ((ViewHolder)viewHolder).rlv.setAdapter(new ItemRlvAdapter(context,data.get(i).getList()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final RecyclerView rlv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_two);
            rlv = itemView.findViewById(R.id.rlv_two);
        }
    }
}
