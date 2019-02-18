package com.bw.xuhongtao.view.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.xuhongtao.R;
import com.bw.xuhongtao.model.bean.Bean;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyRlvAdapter
 * @package com.bw.xuhongtao.view.activity
 * @date 2019/2/16/016 9:02
 */
class MyRlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataEntity> data;
    private static final int TYPE = 0;
    private static final int TYPE1 = 1;

    public MyRlvAdapter(Context context, List<Bean.DataEntity> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE;
        }else{

            return TYPE1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int type = getItemViewType(i);
        if (type == TYPE) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
            MyViewHloder viewHloder = new MyViewHloder(view);
            return viewHloder;
        }
        if (type == TYPE1) {
            View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item2, null, false);
            MyViewHloder1 viewHloder1 = new MyViewHloder1(view1);
            return viewHloder1;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        if(type==TYPE){
            MyViewHloder myViewHloder= (MyViewHloder) viewHolder;
            myViewHloder.textView.setText(data.get(i).getTitle());
            //点击事件
            myViewHloder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnCilck(i);
                }
            });
            //长按事件
            myViewHloder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.OnLongClick(i);
                    return true;
                }
            });
        } if (type==TYPE1){
           MyViewHloder1 myViewHloder1= (MyViewHloder1) viewHolder;
            myViewHloder1.textView.setText(data.get(i).getTitle());
            Glide.with(context).load(data.get(i).getThumbnail_pic_s()).into(myViewHloder1.imageView);
            //点击事件
            myViewHloder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnCilck(i);
                }
            });
            //长按事件
            myViewHloder1.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.OnLongClick(i);
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

  public  class MyViewHloder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHloder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }

   public class MyViewHloder1 extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public MyViewHloder1(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
            imageView=itemView.findViewById(R.id.image);
        }
    }
    //定义接口
    public interface OnItemClickListener{
        void OnCilck(int i);
        void OnLongClick(int i);
    }
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
