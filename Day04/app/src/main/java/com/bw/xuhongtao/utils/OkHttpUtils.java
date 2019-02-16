package com.bw.xuhongtao.utils;

import android.util.Log;

import com.bw.xuhongtao.R;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao
 * @fileName OkHttpUtils
 * @package com.bw.xuhongtao.utils
 * @date 2019/2/15/015 17:30
 */
public class OkHttpUtils {
    public static OkHttpUtils okHttpUtils;

    private OkHttpUtils() {
    }

    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            //添加同步锁
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
    public static void doGet(String url,Callback callback) {
      //创建拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("show",message);
            }
        });
        //设置
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建网络请求对像
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
               .addInterceptor(loggingInterceptor)
                .build();

        //创建请求方式
        Request request=new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }
    public static void doPost(String url, Map<String, String> map,Callback callback) {
        //拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lan",message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建网络请求对像
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
//        创建请求体
        FormBody.Builder requestBody = new FormBody.Builder();
        for (String key : map.keySet()) {
            requestBody.add(key, map.get(key));
        }
        //创建请求方式
            Request request=new Request.Builder().url(url).post(requestBody.build()).build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(callback);

        }
}
