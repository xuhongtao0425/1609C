package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtao.utils.OkHttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName MyModel
 * @package com.bw.xuhongtao.model
 * @date 2019/2/21/021 14:44
 */
public class MyModel {
    //定义接口
    public interface OnMyModelListener {
        void myModelData(  JSONArray result);

    }

    private OnMyModelListener onMyModelListener;

    public void setOnMyModelListener(OnMyModelListener onMyModelListener) {
        this.onMyModelListener = onMyModelListener;
    }

    //创建Handler
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        JSONArray result = jsonObject.getJSONArray("result");
                        if(onMyModelListener!=null){
                            onMyModelListener.myModelData(result);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
    private String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=";

    public void modelData(String path) {
        OkHttpUtils.getOkHttpUtils().doGet(url + path + "&page=1&count=10", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("json",json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);

            }
        });
    }
}
