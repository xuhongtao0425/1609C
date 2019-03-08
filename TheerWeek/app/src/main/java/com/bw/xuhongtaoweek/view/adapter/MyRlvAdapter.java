package com.bw.xuhongtaoweek.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.bean.GoodName;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyRlvAdapter
 * @package com.bw.xuhongtaoweek.view.adapter
 * @date 2019/3/7/007 14:27
 */
public class MyRlvAdapter extends RecyclerView.Adapter {
    Context context;
    List<GoodName.DataEntity> data;
    public MyRlvAdapter(Context context, List<GoodName.DataEntity> data) {
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.classifyoneitem, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ((ViewHolder)viewHolder).title.setText(data.get(i).name);

        ((ViewHolder)viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onMyRlvAdapterListener!=null){
                    onMyRlvAdapterListener.getMyRlvAdapterData(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_one);
        }
    }
    //条目点事件
 public interface OnMyRlvAdapterListener{
        void getMyRlvAdapterData(int i);
    }
    private OnMyRlvAdapterListener onMyRlvAdapterListener;

    public void setOnMyRlvAdapterListener(OnMyRlvAdapterListener onMyRlvAdapterListener) {
        this.onMyRlvAdapterListener = onMyRlvAdapterListener;
    }
}
