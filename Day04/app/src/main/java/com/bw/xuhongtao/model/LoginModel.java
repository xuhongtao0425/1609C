package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtao.utils.OkHttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName LoginModel
 * @package com.bw.xuhongtao.model
 * @date 2019/2/15/015 17:25
 */
public class LoginModel {
    //定义接口
    public interface OnLoginListener{
        void  loginData(String message,String status);
    }
    private OnLoginListener onLoginListener;

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    //创建map集合
    Map<String ,String> map=new HashMap<>();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json= (String) msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(json);
                        String message = jsonObject.getString("message");
                        String status = jsonObject.getString("status");
                        onLoginListener.loginData(message,status);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
    String url="http://172.17.8.100/small/user/v1/login";
    public void loginModel(String phone, String pwd) {
        map.put("phone",phone);
        map.put("pwd",pwd);
        OkHttpUtils.doPost(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message=new Message();
                message.what=0;
                message.obj=json;
                handler.sendMessage(message);
            }
        });

    }
}
