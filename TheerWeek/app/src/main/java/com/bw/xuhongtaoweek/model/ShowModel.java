package com.bw.xuhongtaoweek.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtaoweek.model.bean.GoodName;
import com.bw.xuhongtaoweek.model.bean.ShowBean;
import com.bw.xuhongtaoweek.uilts.OkHttpUilt;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName ShowModel
 * @package com.bw.xuhongtaoweek.model
 * @date 2019/3/7/007 17:05
 */
public class ShowModel {

    public interface OnShowModelListener {
        void getshowModelData( List<ShowBean.DataEntity> data );
    }

    private OnShowModelListener onshowModelListener;

    public void setOnShowModelListener(OnShowModelListener onshowModelListener) {
        this.onshowModelListener = onshowModelListener;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    Gson gson = new Gson();
                    ShowBean showBean = gson.fromJson(json, ShowBean.class);
                    List<ShowBean.DataEntity> data = showBean.getData();
                    if(onshowModelListener!=null){
                        onshowModelListener.getshowModelData(data);
                    }
                    break;
            }
        }
    };

    private String url = "http://172.17.8.100/ks/product/getProducts?pscid=";

    public void showModel(int pscid) {
        OkHttpUilt.getOkHttpUilt().doGet(url + pscid, null, null, new Callback() {
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
