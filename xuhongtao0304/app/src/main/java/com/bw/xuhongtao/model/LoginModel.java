package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;

import com.bw.xuhongtao.utils.OkHttpUtil;

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
 * @date 2019/3/4/004 9:22
 */
public class LoginModel {
    public interface OnLoginModelLinsation {
        void getLoginmodel(String message, String status);
    }

    private OnLoginModelLinsation OnLoginModelLinsation;


    public void setOnLoginModelLinsation(LoginModel.OnLoginModelLinsation onLoginModelLinsation) {
        OnLoginModelLinsation = onLoginModelLinsation;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        String message = jsonObject.getString("message");
                        String status = jsonObject.getString("status");
                        if (OnLoginModelLinsation != null) {
                            OnLoginModelLinsation.getLoginmodel(message, status);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    Map<String, String> map = new HashMap<>();
    private String url = "http://172.17.8.100/small/user/v1/login";

    public void loginModel(String phone, String pass) {
        map.put("phone", phone);
        map.put("pwd", pass);
        OkHttpUtil.getOkHttpUtil().doPost(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
//                Log.i("ssss", json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);
            }
        });


    }
}
