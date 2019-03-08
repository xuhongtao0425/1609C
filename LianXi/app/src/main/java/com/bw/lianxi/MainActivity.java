package com.bw.lianxi;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bw.lianxi.adapter.MyRlvAdapter;
import com.bw.lianxi.bean.Beans;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rlv;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    try {
                        String json = (String) msg.obj;
                        JSONObject jsonObject=new JSONObject(json);
                        JSONArray result = jsonObject.getJSONArray("result");
                        JSONObject rxxp = result.getJSONObject("rxxp");
                        Gson gson=new Gson();
                        Beans beans = gson.fromJson(json, Beans.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;
                case 1 :
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        rlv = findViewById(R.id.rlv);
        //布局管理
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rlv.setLayoutManager(layoutManager);
        //网络请求
        OkHttpUtil.getOkHttpUtil().doGet("http://172.17.8.100/small/commodity/v1/commodityList", new Callback() {
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
        OkHttpUtil.getOkHttpUtil().doGet("http://172.17.8.100/small/commodity/v1/bannerShow", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("json", json);
                Message message = new Message();
                message.what = 1;
                message.obj = json;
                handler.sendMessage(message);
            }
        });

    }
}
