package com.bw.Week2.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.Week2.model.bean.Bean;
import com.bw.Week2.utils.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName ShowModel
 * @package com.bw.Week2.model
 * @date 2019/2/22/022 19:02
 */
public class ShowModel {
    //定义接口
    public interface OnShowListener {
        void showData(List<Bean.ResultEntity> result);
    }

    private OnShowListener onShowListener;

    public void setOnShowListener(OnShowListener onShowListener) {
        this.onShowListener = onShowListener;
    }

    private String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?count=10";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    Gson gson = new Gson();
                    Bean bean = gson.fromJson(json, Bean.class);
                    List<Bean.ResultEntity> result = bean.getResult();
                    if (onShowListener != null) {
                        onShowListener.showData(result);
                    }

                    break;
            }
        }
    };

    public void showModel(int page, String path) {
        OkHttpUtil.getOkHttpUtil().doGet(url + "&page=" + page + "&keyword=" + path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

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
