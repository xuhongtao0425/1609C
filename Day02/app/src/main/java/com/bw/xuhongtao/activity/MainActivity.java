package com.bw.xuhongtao.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.adapter.MyXlistviewAdapter;
import com.bw.xuhongtao.bean.Data;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import xht.bw.com.myxlistview.XListView;

public class MainActivity extends AppCompatActivity {

    private XListView xListView;
    private int num=1;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json= (String) msg.obj;
                    Gson gson=new Gson();
                    Data data = gson.fromJson(json, Data.class);
                    List<Data.DataEntity> data1 = data.getData();
                    xListView.setAdapter(new MyXlistviewAdapter(MainActivity.this,data1));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件
        xListView = findViewById(R.id.xlistview);
        //数据
        getData();
    }

    private void getData() {
//创建网络请求对象
        OkHttpClient okHttpClient=new OkHttpClient();
        //创建请求方式
        Request request=new Request.Builder().url("http://www.xieast.com/api/news/news.php?page="+num).build();
        //创建请求
        Call call = okHttpClient.newCall(request);
        //执行请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
//                Log.i("Dood",string);
                Message message=new Message();
                message.what=0;
                message.obj=string;
                handler.sendMessage(message);
            }
        });
    }
}
