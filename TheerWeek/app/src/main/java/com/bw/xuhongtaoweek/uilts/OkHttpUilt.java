package com.bw.xuhongtaoweek.uilts;

import android.util.Log;

import com.bw.xuhongtaoweek.R;

import java.io.IOException;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao
 * @fileName OkHttpUilt
 * @package com.bw.xuhongtaoweek.uilts
 * @date 2019/3/7/007 13:45
 */
public class OkHttpUilt {
    private static OkHttpUilt okHttpUilt;

    private OkHttpUilt() {
    }

    public static OkHttpUilt getOkHttpUilt() {
        if (okHttpUilt == null) {
            synchronized (OkHttpUilt.class) {
                if (okHttpUilt == null) {
                    okHttpUilt = new OkHttpUilt();
                }
            }
        }
        return okHttpUilt;
    }

    //封装ok
    private static OkHttpClient okHttpClient;

    private static synchronized OkHttpClient getOkHttpClient(String sessionId, String userId) {
        if (okHttpClient == null) {
            //日志拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("lanjie", message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request response = chain.request()
                            .newBuilder()
                            .addHeader("source", "android")
                            .build();
                    return chain.proceed(response);
                }
            }).build();
        }
        return okHttpClient;
    }
    //doGet
    public void  doGet(String url,String sessionId, String userId,Callback callback){
        OkHttpClient okHttpClient = getOkHttpClient(sessionId, userId);
        //请求方式
        Request response=new Request.Builder().url(url).build();
        //执行
        okHttpClient.newCall(response).enqueue(callback);

    }
    //doPost
    public void  doPost(String url, String sessionId, String userId, Map<String ,String> map,Callback callback){
        OkHttpClient okHttpClient = getOkHttpClient(sessionId, userId);

        FormBody.Builder body=new FormBody.Builder();
        for (String key:map.keySet()) {
            body.add(key,map.get(key));
        }

        //请求方式
        Request response=new Request.Builder().url(url).post(body.build()).build();
        //执行
        okHttpClient.newCall(response).enqueue(callback);

    }

}
