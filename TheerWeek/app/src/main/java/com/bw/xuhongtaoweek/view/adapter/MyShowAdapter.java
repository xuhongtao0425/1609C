package com.bw.xuhongtaoweek.view.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.xuhongtaoweek.R;
import com.bw.xuhongtaoweek.model.bean.GoodName;
import com.bw.xuhongtaoweek.model.bean.ShowBean;
import com.bw.xuhongtaoweek.uilts.OkHttpUilt;
import com.bw.xuhongtaoweek.view.activity.ShowActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName MyShowAdapter
 * @package com.bw.xuhongtaoweek.view.adapter
 * @date 2019/3/7/007 17:48
 */
public class MyShowAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ShowBean.DataEntity> data;
    private String url = "http://172.17.8.100/ks/product/addCart?uid=51&pid=";

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        String msg1 = jsonObject.getString("msg");
                        String code = jsonObject.getString("code");
                        if (code.equals("0")) {
                            Toast.makeText(context, msg1, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, msg1, Toast.LENGTH_SHORT).show();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    public MyShowAdapter(Context context, List<ShowBean.DataEntity> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.showitem, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder) viewHolder).title.setText(data.get(i).getTitle());
        ((ViewHolder) viewHolder).price.setText(data.get(i).getPrice() + "");
        Glide.with(context).load(data.get(i).images.split("\\|")[0].replace("https", "http")).into(((ViewHolder) viewHolder).imageView);
        final int pid = data.get(i).getPid();

        ((ViewHolder) viewHolder).itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                OkHttpUilt.getOkHttpUilt().doGet(url + pid, null, null, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String json = response.body().string();
//                           Log.i("json",json);
                        Message message = new Message();
                        message.what = 0;
                        message.obj = json;
                        handler.sendMessage(message);
                    }
                });


                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title, price;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_show);
            price = itemView.findViewById(R.id.price_show);
            imageView = itemView.findViewById(R.id.image_show);
        }
    }

}
