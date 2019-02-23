package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtao.model.bean.Bean;
import com.bw.xuhongtao.model.bean.Data;
import com.bw.xuhongtao.model.bean.Datas;
import com.bw.xuhongtao.utils.OkhttpUtils;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.utils.L;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName ShowModel
 * @package com.bw.xuhongtao.model
 * @date 2019/2/18/018 9:02
 */
public class ShowModel {
    public interface OnShowListener{
        void  getShowData(JSONArray data1);
    }
    private  OnShowListener onShowListener;

    public void setOnShowListener(OnShowListener onShowListener) {
        this.onShowListener = onShowListener;
    }

    private String url="http://365jia.cn/news/api3/365jia/news/headline";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json=(String) msg.obj;
//                    Gson gson=new Gson();
//                    Bean bean = gson.fromJson(json, Bean.class);
//                    Data data = bean.getData();
//                   ArrayList<Datas> data1 = data.getData();
//                    Log.i("data1",data1.toString());


                                        try {
                        JSONObject jsonObject=new JSONObject(json);
                        JSONObject data = jsonObject.getJSONObject("data");
                        JSONArray data1 = data.getJSONArray("data");

                        if(onShowListener!=null){
                            onShowListener.getShowData(data1);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };
    public void showModel(int page) {
        OkhttpUtils.doGet(url+"?page="+page, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
//                Log.i("xxx",json);
                Message message=new Message();
                message.what=0;
                message.obj=json;
                handler.sendMessage(message);

            }
        });
    }
}
