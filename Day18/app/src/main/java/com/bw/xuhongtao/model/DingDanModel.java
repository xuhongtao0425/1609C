package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtao.OkHttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

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

    public interface OnDingDanModel{
        void getData( JSONArray result);
    }
    private OnDingDanModel onDingDanModel;

    public void setOnDingDanModel(OnDingDanModel onDingDanModel) {
        this.onDingDanModel = onDingDanModel;
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json=(String) msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(json);
                        JSONArray result = jsonObject.getJSONArray("result");
                        if(onDingDanModel!=null){
                            onDingDanModel.getData(result);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
    private String url="http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?count=10&page=";
    public void dingdanModel(int page) {
        OkHttpUtils.getOkHttpUtils().doGet(url + page + "&labelId=1003", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("json",json);
                Message message=new Message();
                message.what=0;
                message.obj=json;
                handler.sendMessage(message);

            }
        });
    }
}
