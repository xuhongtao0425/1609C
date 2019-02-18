package com.bw.xuhongtao.utils;

import android.util.Log;

import com.bw.xuhongtao.R;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao   单例模式
 * @fileName OkhttpUtils
 * @package com.bw.xuhongtao.utils
 * @date 2019/2/18/018 9:04
 */
public class OkhttpUtils {
    private static OkhttpUtils okhttpUtils;

    private OkhttpUtils() {
    }

    public static OkhttpUtils getOkhttpUtils() {
        if (okhttpUtils != null) {
            synchronized (OkhttpUtils.class) {
                if (okhttpUtils != null) {
                    okhttpUtils = new OkhttpUtils();
                }
            }
        }
        return okhttpUtils;
    }

    //get请求方法
    public static void doGet(String url, Callback callback) {
        //创建拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lan", message);
            }
        });
        //设置拦截方位
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建网络请求对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        //创建请求方式i
        Request request = new Request.Builder().url(url).build();
        //执行网络请求
        okHttpClient.newCall(request).enqueue(callback);


    }

    //post请求方法
    public static void doPost(String url, Map<String, String> map, Callback callback) {
        //创建拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lan", message);
            }
        });
        //设置拦截方位
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建网络请求对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        //创建请求体
        FormBody.Builder formBody = new FormBody.Builder();
        for (String m : map.keySet()) {
            formBody.add(m, map.get(m));
        }
        //创建请求方式i
        Request request = new Request.Builder().url(url).post(formBody.build()).build();
        //执行网络请求
        okHttpClient.newCall(request).enqueue(callback);


    }

}
