package com.bw.xuhongtao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author xuhongtao
 * @fileName MyRlvAdapter
 * @package com.bw.xuhongtao.view.activity
 * @date 2019/2/18/018 9:44
 */
public class MyRlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    JSONArray data1;
    private static final int TYPE = 0;
    private static final int TYPE1 = 1;
    private DisplayImageOptions options;

    public MyRlvAdapter(Context context, JSONArray data1) {
        this.context = context;
        this.data1 = data1;
        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .build();
    }

    @Override
    public int getItemViewType(int position) {
        position++;
        if (position % 4 == 0) {
            return TYPE1;
        } else {
            return TYPE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == TYPE1) {
            View view = View.inflate(context, R.layout.item1, null);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        } else {
            View view = View.inflate(context, R.layout.item2, null);
            ViewHolder1 viewHolder1 = new ViewHolder1(view);
            return viewHolder1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        try {
            if (viewHolder instanceof ViewHolder1) {

                for (int j = 0; j < data1.length(); j++) {
                    JSONObject jsonObject = data1.getJSONObject(i);
                    ((ViewHolder1) viewHolder).textView.setText(jsonObject.getString("title"));
                    JSONArray pics = jsonObject.getJSONArray("pics");


                    ImageLoader.getInstance().displayImage("http://img.365jia.cn/uploads/" + pics.get(0), ((ViewHolder1) viewHolder).imageView, options);

                }

            } else {
                for (int j = 0; j < data1.length(); j++) {
                    JSONObject jsonObject = data1.getJSONObject(i);
                    ((ViewHolder) viewHolder).textView.setText(jsonObject.getString("title"));
                    JSONArray pics = jsonObject.getJSONArray("pics");


                    ImageLoader.getInstance().displayImage("http://img.365jia.cn/uploads/" + pics.get(0), ((ViewHolder) viewHolder).imageView, options);

                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onClick.Onclick(data1,i);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return data1.length();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item1);
            imageView = itemView.findViewById(R.id.image_item1);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item2);
            imageView = itemView.findViewById(R.id.image_item2);
        }
    }

    public interface OnClick {
        void Onclick(JSONArray data1, int i);
    }

    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }
}
