package com.bw.xuhongtaoweek.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtaoweek.model.bean.GoodName;
import com.bw.xuhongtaoweek.model.bean.GoodsClssBean;
import com.bw.xuhongtaoweek.uilts.OkHttpUilt;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName ClassifyTwoMolde
 * @package com.bw.xuhongtaoweek.model
 * @date 2019/3/7/007 14:52
 */
public class ClassifyTwoMolde {
    public interface OnClassifyTwoMoldeListener {
        void getClassifyTwoMoldeData(List<GoodsClssBean.DataEntity> data);
    }

    private OnClassifyTwoMoldeListener onClassifyTwoMoldeListener;

    public void setOnClassifyTwoMoldeListener(OnClassifyTwoMoldeListener onClassifyTwoMoldeListener) {
        this.onClassifyTwoMoldeListener = onClassifyTwoMoldeListener;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    Gson gson = new Gson();
                    GoodsClssBean goodsClssBean = gson.fromJson(json, GoodsClssBean.class);
                    List<GoodsClssBean.DataEntity> data = goodsClssBean.getData();
                    if (onClassifyTwoMoldeListener != null) {
                        onClassifyTwoMoldeListener.getClassifyTwoMoldeData(data);
                    }
                    break;
            }
        }
    };
    private String url = "http://172.17.8.100/ks/product/getProductCatagory?cid=";

    public void classifyTwoMolde(int cid) {
        OkHttpUilt.getOkHttpUilt().doGet(url + cid, null, null, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
//                Log.i("json", json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);
            }
        });
    }
}
