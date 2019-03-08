package com.bw.xuhongtao0306.utils;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao
 * @fileName OkHttpUtils
 * @package com.bw.xuhongtao
 * @date 2019/3/5/005 8:57
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
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lanjie", message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        }
        return okHttpClient;
    }

    public void doGet(String url, Callback callback) {
        OkHttpClient okHttpClient = getOkHttpClient();
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }


}
