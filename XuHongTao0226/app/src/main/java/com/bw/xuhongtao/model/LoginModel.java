package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

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
 * @date 2019/2/26/026 8:55
 */
public class LoginModel {
    //创建接口
    public interface OnLoginModelListener{
        void getData(String message,String status);
    }
    private OnLoginModelListener onLoginModelListener;

    public void setOnLoginModelListener(OnLoginModelListener onLoginModelListener) {
        this.onLoginModelListener = onLoginModelListener;
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json=(String)msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(json);
                        String message = jsonObject.getString("message");
                        String status = jsonObject.getString("status");
                        if(onLoginModelListener!=null){
                            onLoginModelListener.getData(message,status);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    private String url="http://172.17.8.100/small/user/v1/login";
    //创建map集合
    Map<String ,String> map=new HashMap<>();

    public void logonMolde(String phone, String pwd) {
        map.put("phone",phone);
        map.put("pwd",pwd);
        //调用doPost
        OkHttpUtil.getOkHttpUtil().doPost(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
//                Log.i("json",json);
                Message message=new Message();
                message.what=0;
                message.obj=json;
                handler.sendMessage(message);
            }
        });
    }
}
