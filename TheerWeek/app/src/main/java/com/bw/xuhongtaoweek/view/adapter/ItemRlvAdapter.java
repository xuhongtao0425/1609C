package com.bw.xuhongtaoweek.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.bean.GoodsClssBean;
import com.bw.xuhongtaoweek.persenter.ShowPersenter;
import com.bw.xuhongtaoweek.view.activity.ShowActivity;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName ItemRlvAdapter
 * @package com.bw.xuhongtaoweek.view.adapter
 * @date 2019/3/7/007 15:42
 */
class ItemRlvAdapter extends RecyclerView.Adapter {
    Context context;
    List<GoodsClssBean.DataEntity.ListEntity> list;



    public ItemRlvAdapter(Context context, List<GoodsClssBean.DataEntity.ListEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemrlv, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ((ViewHolder) viewHolder).title.setText(list.get(i).getName());
                Glide.with(context)
                .load((list.get(i).getIcon().split("\\|")[0].replace("https", "http")))
                .error(R.drawable.a3)
                .fallback(R.drawable.a3)
                .into(((ViewHolder) viewHolder).image);
        ((ViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pscid = list.get(i).getPscid();
                Intent intent = new Intent(context, ShowActivity.class);
                intent.putExtra("pascid",pscid);
               context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_item);
            image = itemView.findViewById(R.id.image_item);
        }
    }
public interface OnShowAdapterListener{
        void getShowAdapterData(int i);
}
private OnShowAdapterListener onShowAdapterListener;

    public void setOnShowAdapterListener(OnShowAdapterListener onShowAdapterListener) {
        this.onShowAdapterListener = onShowAdapterListener;
    }
}
