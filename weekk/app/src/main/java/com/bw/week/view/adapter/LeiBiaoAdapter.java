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

import com.bw.week.R;
import com.bw.week.model.bean.LeiBiaoBean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName LeiBiaoAdapter
 * @package com.bw.week.view.adapter
 * @date 2019/3/2/002 9:17
 */
public class LeiBiaoAdapter extends RecyclerView.Adapter {
    Context context;
    List<LeiBiaoBean.ResultEntity> result;

    public LeiBiaoAdapter(Context context, List<LeiBiaoBean.ResultEntity> result) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.leibiaoone, null, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ((ViewHolder1)viewHolder).lb.setText(result.get(i).getName());
        ((ViewHolder1)viewHolder).lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onLeiBiaoitemListener!=null){
                    onLeiBiaoitemListener.getData(result.get(i).getId());

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView lb;


        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            lb = itemView.findViewById(R.id.lb);
        }
    }
    //点击事件
    public interface OnLeiBiaoItemListener{
        void  getData(String id);
    }
    private OnLeiBiaoItemListener onLeiBiaoitemListener;

    public void setOnLeiBiaoItemListener(OnLeiBiaoItemListener OnLeiBiaoitemListener) {
        this.onLeiBiaoitemListener = OnLeiBiaoitemListener;
    }
}
