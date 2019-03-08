package com.bw.xuhongtao.utils;

import android.util.Log;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao
 * @fileName OkHttpUtil
 * @package com.bw.xuhongtao
 * @date 2019/3/4/004 9:23
 */
public class OkHttpUtil {
    private static OkHttpUtil okHttpUtil;

    private OkHttpUtil() {
    }

    public static OkHttpUtil getOkHttpUtil() {
        if (okHttpUtil == null) {
            synchronized (OkHttpUtil.class) {
                if (okHttpUtil == null) {
                    okHttpUtil = new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }

    //封装okhttp
    private static OkHttpClient okHttpClient;

    public static synchronized OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lan", message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        return okHttpClient;
    }

    //dopost方法
    public void doPost(String url, Map<String, String> map, Callback callback) {
        OkHttpClient okHttpClient = getOkHttpClient();
        FormBody.Builder body = new FormBody.Builder();
        for (String m : map.keySet()) {
            body.add(m, map.get(m));
        }
        Request request = new Request.Builder().url(url).post(body.build()).build();
        okHttpClient.newCall(request).enqueue(callback);

    }

}
