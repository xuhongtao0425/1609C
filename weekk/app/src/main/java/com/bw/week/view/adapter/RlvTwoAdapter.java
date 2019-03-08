package com.bw.week.view.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.week.R;
import com.bw.week.model.bean.GoodBean;
import com.bw.week.model.bean.LeiBiaoTwoBean;
import com.bw.week.utils.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName RlvTwoAdapter
 * @package com.bw.week.view.adapter
 * @date 2019/3/2/002 10:29
 */
public class RlvTwoAdapter extends RecyclerView.Adapter {
private String url="http://172.17.8.100/small/commodity/v1/findCommodityByCategory?page=1&count=6&categoryId=";
  private Handler handler=new Handler();
    Context context;
    List<LeiBiaoTwoBean.ResultEntity> result;


    public RlvTwoAdapter(Context context, List<LeiBiaoTwoBean.ResultEntity> result) {
        this.context=context;
        this.result=result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.leibiaotwoitem, null, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder1)viewHolder).text_two.setText(result.get(i).getName());
            //获取id
            String id = result.get(i).getId();
            //网络请求
        OkHttpUtil.getOkHttpUtil().doGet(url + id, new Callback() {
                @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String json = response.body().string();
               handler.post(new Runnable() {
                   @Override
                   public void run() {
                       Gson gson=new Gson();
                       GoodBean goodBean = gson.fromJson(json, GoodBean.class);
                       List<GoodBean.ResultEntity> result = goodBean.getResult();
                       GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3);
                       ((ViewHolder1)viewHolder).rlv_itemtwo.setLayoutManager(gridLayoutManager);
                       ((ViewHolder1)viewHolder).rlv_itemtwo.setAdapter(new GoodAdapter(context,result));
                   }
               });
            }
        });


    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView text_two;
        private RecyclerView rlv_itemtwo;


        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            text_two = itemView.findViewById(R.id.text_two);
            rlv_itemtwo = itemView.findViewById(R.id.rlv_two);

        }
    }
}
