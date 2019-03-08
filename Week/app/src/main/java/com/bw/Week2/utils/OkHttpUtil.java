package com.bw.Week2.utils;

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
 * @package com.bw.Week2.utils
 * @date 2019/2/23/023 10:49
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
    private static OkHttpClient okHttpClient = null;

    private static synchronized OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("lan", message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        }
        return okHttpClient;
    }

    //doget
    public void doGet(String url, Callback callback) {
        OkHttpClient okHttpClient = getOkHttpClient();
        //请求方式
        Request request = new Request.Builder().url(url).build();
        //执行
        okHttpClient.newCall(request).enqueue(callback);
    } //dopost

    public void doPost(String url, Map<String, String> map, Callback callback) {
        OkHttpClient okHttpClient = getOkHttpClient();
        //请求体
        FormBody.Builder formbyod = new FormBody.Builder();
        //取值
        for (String ma : map.keySet()) {
            formbyod.add(ma,map.get(ma));

        }
        //请求方式
        Request request = new Request.Builder().url(url).post(formbyod.build()).build();
        //执行
        okHttpClient.newCall(request).enqueue(callback);
    }
}
