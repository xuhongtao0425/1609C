package com.bw.xuhongtao.utils;

import android.util.Log;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao
 * @fileName OkHttpUtil
 * @package com.bw.xuhongtao.utils
 * @date 2019/2/19/019 9:08
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

    //封装okhppt
    private static OkHttpClient okHttpClient;

    private synchronized static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("lanjieqi", message);
            }
        });
        //拦截请求体数据
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }
        return okHttpClient;
    }

    //get请求
    public static void doGet(String url, Callback callback) {
        //创建okhttp对象
        OkHttpClient okHttpClient = getOkHttpClient();
        //创建请求方式
        Request request = new Request.Builder().url(url).build();
        //执行网络请求
        okHttpClient.newCall(request).enqueue(callback);
    }
    //get请求
    public static void doPost(String url, Map<String,String> map, Callback callback) {
        //创建okhttp对象
        OkHttpClient okHttpClient = getOkHttpClient();
        FormBody.Builder formbody=new FormBody.Builder();
        for (String key: map.keySet()) {
            formbody.add(key,map.get(key));
        }
        //创建请求方式
        Request request = new Request.Builder().post(formbody.build()).url(url).build();
        //执行网络请求
        okHttpClient.newCall(request).enqueue(callback);
    }

}
