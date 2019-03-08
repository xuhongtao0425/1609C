package com.bw.lianxi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.lianxi.MainActivity;
import com.bw.lianxi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author xuhongtao
 * @fileName MyRlvAdapter
 * @package com.bw.lianxi.adapter
 * @date 2019/2/27/027 16:50
 */
public class MyRlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    JSONObject result;
    private static int TYPE = 0;
    private static int TYPE1 = 1;
    private static int TYPE2 = 2;

    public MyRlvAdapter(Context context, JSONObject result) {
        this.context = context;
        this.result = result;
    }

    @Override
    public int getItemViewType(int position) {
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
        ViewHloder viewHloder=null;
        if(i==TYPE){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
            viewHloder= new ViewHloder(view);
            return viewHloder;
        }else if(i==TYPE1){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item1, null, false);
            ViewHloder1 viewHloder1= new ViewHloder1(view);
            return viewHloder1;
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item2, null, false);
        ViewHloder2 viewHloder2= new ViewHloder2(view);
        return viewHloder2;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if(type==TYPE){
            try {
                JSONArray rxxp = result.getJSONArray("rxxp");
                for (int j = 0; j < rxxp.length(); j++) {
                    JSONObject jsonObject = rxxp.getJSONObject(j);
                    ((ViewHloder)viewHolder).textView.setText(jsonObject.getString("commodityName"));
                    ((ViewHloder)viewHolder).textView1.setText(jsonObject.getString("price"));
                    Glide.with(context).load(jsonObject.getString("masterPic")).into(((ViewHloder)viewHolder).image);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public int getItemCount() {
        return result.length();
    }

    class ViewHloder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView textView;
        private final TextView textView1;

        public ViewHloder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text1);
            textView1 = itemView.findViewById(R.id.text2);
        }
    }

    class ViewHloder1 extends RecyclerView.ViewHolder {

        public ViewHloder1(@NonNull View itemView) {
            super(itemView);
        }
    }

    class ViewHloder2 extends RecyclerView.ViewHolder {

        public ViewHloder2(@NonNull View itemView) {
            super(itemView);
        }
    }
}
