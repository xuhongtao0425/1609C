package com.bw.xuhongtao.utils;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao
 * @fileName OkHttpUtils
 * @package com.bw.xuhongtao.utils
 * @date 2019/2/16/016 8:21
 */
public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;

    private OkHttpUtils() {
    }
    public static OkHttpUtils getOkHttpUtils(){
        if(okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if(okHttpUtils==null){
                    okHttpUtils=new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
    public static void doGet(String url, Callback callback){
//        创建拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lan",message);
            }
        });
        //设置拦截
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //创建网络请求对象
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        //创建请求方式
        Request request=new Request.Builder()
                .url(url)
                .build();
        //执行请求
        okHttpClient.newCall(request).enqueue(callback);

    }
}
