package com.bw.xuhongtaoweek.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.bean.ShoppingBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShoppingAdapter
 * @package com.bw.xuhongtaoweek.view.adapter
 * @date 2019/3/7/007 18:44
 */
public class ShoppingAdapter extends RecyclerView.Adapter {
    Context context;
    List<ShoppingBean.DataEntity> data;

    public ShoppingAdapter(Context context, List<ShoppingBean.DataEntity> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.shoppingcaritem, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        ((ViewHolder) viewHolder).title.setText(data.get(i).sellerName);
        ((ViewHolder) viewHolder).checkBox.setChecked(data.get(i).ischecked);
        //布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        ((ViewHolder) viewHolder).rlv.setLayoutManager(layoutManager);
        List<ShoppingBean.DataEntity.ListEntity> list = data.get(i).getList();
        ShoppingitemAdapter adapter = new ShoppingitemAdapter(context, list);
        ((ViewHolder) viewHolder).rlv.setAdapter(adapter);
        //二级
        adapter.setOnchectwokBoxListener(new ShoppingitemAdapter.OncheckTwoBoxListener() {
            @Override
            public void getchecktwoBoxData(boolean frag, int c) {
                if(onBoxListener!=null){
                    onBoxListener.getcheckBoxData(frag,c,i);
                }

            }
        });
        //
        ((ViewHolder) viewHolder).checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((ViewHolder) viewHolder).checkBox.isChecked();
                if(oncheckBoxListener!=null){
                    oncheckBoxListener.getcheckBoxData(checked,i);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final RecyclerView rlv;
        private final CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_shopping);
            rlv = itemView.findViewById(R.id.rlv2_shopping);
            checkBox = itemView.findViewById(R.id.checked_shopping);
        }
    }

    //一级
    public interface OncheckBoxListener {
        void getcheckBoxData(boolean frag, int i);
    }
    private OncheckBoxListener oncheckBoxListener;

    public void setOncheckBoxListener(OncheckBoxListener oncheckBoxListener) {
        this.oncheckBoxListener = oncheckBoxListener;
    } //二级
    public interface OnBoxListener {
        void getcheckBoxData(boolean frag, int i,int num);
    }
    private OnBoxListener onBoxListener;

    public void setBoxListener(OnBoxListener onBoxListener) {
        this.onBoxListener = onBoxListener;
    }
}
