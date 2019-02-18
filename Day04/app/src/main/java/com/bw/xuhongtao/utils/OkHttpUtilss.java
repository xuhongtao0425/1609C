package com.bw.xuhongtao.utils;

import android.util.Log;


import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao
 * @fileName OkHttpUtilss
 * @package com.bw.xuhongtao.utils
 * @date 2019/2/17/017 15:52
 */
public class OkHttpUtilss {
    private static OkHttpUtilss okHttpUtilss;

    private OkHttpUtilss() {
    }

    public static OkHttpUtilss getOkHttpUtilss() {
        if (okHttpUtilss == null) {
            synchronized (OkHttpUtilss.class) {
                if (okHttpUtilss == null) {
                    okHttpUtilss = new OkHttpUtilss();
                }
            }
        }
        return okHttpUtilss;
    }
    public static void doGet(String url, Callback callback){
        //创建拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("loggingInterceptor",message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建网络请求对象
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        //创建请求方式
        Request request=new Request.Builder().url(url).build();
        //执行请求
        okHttpClient.newCall(request).enqueue(callback);
    }

}
