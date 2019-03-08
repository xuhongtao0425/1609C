package com.bw.Week2.model;

import android.os.Handler;
import android.os.Message;

import com.bw.Week2.model.bean.Bean;
import com.bw.Week2.utils.OkHttpUtil;
import com.bw.Week2.utils.Paht;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName LoginModel
 * @package com.bw.Week2.model
 * @date 2019/2/23/023 16:08
 */
public class LoginModel {
    public interface OnLoginModelListener{
        void getData(String message,String status);
    }
    private OnLoginModelListener nLoginModelListener;

    public void setOnLoginModelListener(OnLoginModelListener nLoginModelListener) {
        this.nLoginModelListener = nLoginModelListener;
    }
    private Map<String ,String> map=new HashMap<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(json);
                        String status = jsonObject.getString("status");
                        String message = jsonObject.getString("message");
                        if(nLoginModelListener!=null){
                            nLoginModelListener.getData(message,status);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    break;
            }
        }
    };
    public void loginModel(String name, String pwd) {
        map.put("phone",name);
        map.put("pwd",pwd);
        OkHttpUtil.getOkHttpUtil().doPost(Paht.login, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);

            }
        });
    }
}