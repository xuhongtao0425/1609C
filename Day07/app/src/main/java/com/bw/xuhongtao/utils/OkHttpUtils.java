package com.bw.xuhongtao.utils;

import android.util.Log;

import com.bw.xuhongtao.R;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao
 * @fileName OkHttpUtils
 * @package com.bw.xuhongtao.utils
 * @date 2019/2/21/021 14:57
 */
public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;

    private OkHttpUtils() {

    }

    public static OkHttpUtils getOkHttpUtils() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    //封装okhttp
    private static OkHttpClient okHttpClient;

    private static synchronized OkHttpClient getOkHttpClient() {
        //拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lan", message);
            }
        });
        //拦截器模式
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        }
        return okHttpClient;
    }

    //get请求
    public void doGet(String path, Callback callback) {
        OkHttpClient okHttpClient = getOkHttpClient();
        //请求方式
        Request request = new Request.Builder().url(path).build();
        //执行请求
        okHttpClient.newCall(request).enqueue(callback);

    }
    //post请求


}
