package com.bw.Week2.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.Week2.model.bean.Bean;
import com.bw.Week2.utils.OkHttpUtil;
import com.bw.Week2.utils.Paht;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName GoodsModel
 * @package com.bw.Week2.model
 * @date 2019/2/23/023 10:47
 */
public class GoodsModel {
    //创建接口
    public interface OnGoodsModelListener{
        void getData(List<Bean.ResultEntity> result);
    }
    private OnGoodsModelListener onGoodsModelListener;

    public void setOnGoodsModelListener(OnGoodsModelListener onGoodsModelListener) {
        this.onGoodsModelListener = onGoodsModelListener;
    }

    //
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    Gson gson=new Gson();
                    Bean bean = gson.fromJson(json, Bean.class);
                    List<Bean.ResultEntity> result = bean.getResult();
                    if(onGoodsModelListener!=null){
                        onGoodsModelListener.getData(result);
                    }

                    break;
            }
        }
    };

    public void goodsModel(int page, String name) {
        OkHttpUtil.getOkHttpUtil().doGet(Paht.goods + name + "&page=" + page, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("cuowu", e.getMessage());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("xxx", json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);


            }
        });
    }
}
