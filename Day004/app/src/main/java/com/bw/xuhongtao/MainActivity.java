package com.bw.xuhongtao;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nostra13.universalimageloader.utils.L;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rlv;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json=(String ) msg.obj;
//                    Log.i("xxx",json);
                    try {
                        JSONObject jsonObject=new JSONObject(json);
                        JSONObject data = jsonObject.getJSONObject("data");
                        JSONArray data1 = data.getJSONArray("data");
                        final MyRlvAdapter adapter = new MyRlvAdapter(MainActivity.this, data1);
                        rlv.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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
        //创建布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置布局管理器
        rlv.setLayoutManager(layoutManager);
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url("http://365jia.cn/news/api3/365jia/news/headline?page=1").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("cakkk",e.getMessage());
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
