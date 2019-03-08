package com.bw.xuhongtaoweek.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.bean.ShoppingBean;
import com.bw.xuhongtaoweek.view.widget.AdderClass;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName ShoppingitemAdapter
 * @package com.bw.xuhongtaoweek.view.adapter
 * @date 2019/3/7/007 18:55
 */
public class ShoppingitemAdapter extends RecyclerView.Adapter {
    Context context;
    List<ShoppingBean.DataEntity.ListEntity> list;
    int num;

    public ShoppingitemAdapter() {
    }

    public ShoppingitemAdapter(Context context, List<ShoppingBean.DataEntity.ListEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.shoppingitemtwo, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        ((ViewHolder) viewHolder).title.setText(list.get(i).getTitle());
        ((ViewHolder) viewHolder).price.setText(list.get(i).getPrice() + "");
        ((ViewHolder) viewHolder).checkBox.setChecked(list.get(i).isItchecked());
        Glide.with(context).load(list.get(i).getImages().split("\\|")[0].replace("https", "http")).into(((ViewHolder) viewHolder).image);
            ((ViewHolder) viewHolder).checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean checked = ((ViewHolder) viewHolder).checkBox.isChecked();
                    if(onchecktwoBoxListener!=null){
                        onchecktwoBoxListener.getchecktwoBoxData(checked,i);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title, price;
        private final ImageView image;
        private final CheckBox checkBox;
        private final AdderClass adderClass;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_shoppingitem);
            image = itemView.findViewById(R.id.image);
            checkBox = itemView.findViewById(R.id.checked_shoppingitem);
            price = itemView.findViewById(R.id.price_shoppingitem);
            adderClass = itemView.findViewById(R.id.adder);
        }
    }
    //一级
    public interface OncheckTwoBoxListener {
        void getchecktwoBoxData(boolean frag, int i);
    }
    private OncheckTwoBoxListener onchecktwoBoxListener;

    public void setOnchectwokBoxListener(OncheckTwoBoxListener onchecktwoBoxListener) {
        this.onchecktwoBoxListener = onchecktwoBoxListener;
    }
}
