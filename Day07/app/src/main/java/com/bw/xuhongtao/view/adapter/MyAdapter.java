package com.bw.xuhongtao.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.xuhongtao.R;
import com.bw.xuhongtao.view.activity.MainActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author xuhongtao
 * @fileName MyAdapter
 * @package com.bw.xuhongtao.view.adapter
 * @date 2019/2/21/021 15:28
 */
public class MyAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private Context context;
    private JSONArray result;

    public MyAdapter(Context context, JSONArray result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
        ViewHolder1 viewHolder1=new ViewHolder1(view);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder viewHolder, int i) {
        try {
            JSONObject object = result.getJSONObject(i);

            ((ViewHolder1) viewHolder).textView.setText(object.getString("commodityName"));
            Glide.with(context).load(object.getString("masterPic")).into(((ViewHolder1) viewHolder).imageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return result.length();
    }

    class ViewHolder1 extends XRecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_item);
            textView = itemView.findViewById(R.id.text_item);
        }
    }
}
