package com.bw.xuhongtao0306.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtao0306.model.bean.Data;
import com.bw.xuhongtao0306.model.bean.Json;
import com.bw.xuhongtao0306.utils.OkHttpUtils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName DingDanModel
 * @package com.bw.xuhongtao.model
 * @date 2019/3/5/005 8:56
 */
public class DingDanModel {

    public interface OnDingDanModel {
        void getData(List<Data> data);
    }

    private OnDingDanModel onDingDanModel;

    public void setOnDingDanModel(OnDingDanModel onDingDanModel) {
        this.onDingDanModel = onDingDanModel;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    Gson gson = new Gson();
                    Json json1 = gson.fromJson(json, Json.class);
                    List<Data> data = json1.getData();
                    Log.i("data", data.toString());
                    if (onDingDanModel != null) {
                        onDingDanModel.getData(data);
                    }
                    break;
            }
        }
    };
    private String url = "http://www.wanandroid.com/tools/mockapi/6523/restaurant-list";

    public void dingdanModel() {
        OkHttpUtils.getOkHttpUtils().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("json", json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);

            }
        });
    }
}
