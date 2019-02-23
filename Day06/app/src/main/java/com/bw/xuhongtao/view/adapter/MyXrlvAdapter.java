package com.bw.xuhongtao.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.xuhongtao.MainActivity;
import com.bw.xuhongtao.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyXrlvAdapter
 * @package com.bw.xuhongtao.view.adapter
 * @date 2019/2/19/019 17:33
 */
public class MyXrlvAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    Context context;
JSONArray list;
    private static final int TYPE = 0;
    private static final int TYPE1 = 1;


    public MyXrlvAdapter(Context context) {
        this.context = context;

    }


    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return TYPE;
        } else {
            return TYPE1;
        }
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == TYPE) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        } else {
            View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item1, null, false);
            ViewHolder1 viewHolder1 = new ViewHolder1(view1);
            return viewHolder1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        try {
            if (type == TYPE) {

                JSONArray jsonArray = list.get(0);
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ((ViewHolder) viewHolder).textView.setText(jsonObject.getString("commodityName"));
                Glide.with(context).load(jsonObject.getString("masterPic")).into(((ViewHolder) viewHolder).imageView);
            }else{
                JSONArray jsonArray = list.get(0);
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ((ViewHolder1) viewHolder).textView.setText(jsonObject.getString("commodityName"));
                Glide.with(context).load(jsonObject.getString("masterPic")).into(((ViewHolder1) viewHolder).imageView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.length();
    }

    public void addList(JSONArray data) {

    }

    public void updateList(JSONArray data) {
    }

    public class ViewHolder extends XRecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item);
            imageView = itemView.findViewById(R.id.image_item);
        }
    }

    public class ViewHolder1 extends XRecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item1);
            imageView = itemView.findViewById(R.id.image_item1);
        }
    }
}
