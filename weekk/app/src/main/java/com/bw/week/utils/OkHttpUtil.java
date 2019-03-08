package com.bw.week.utils;

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
 * @package com.bw.week.utils
 * @date 2019/2/28/028 18:22
 */
public class OkHttpUtil {
    private static OkHttpUtil okHttpUtil;

    private OkHttpUtil() {
    }
    public static OkHttpUtil getOkHttpUtil(){
        if(okHttpUtil==null){
            synchronized (OkHttpUtil.class){
                if(okHttpUtil==null){
                    okHttpUtil=new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }
    //封装OKHTTP
    private static OkHttpClient okHttpClient=null;
    private  static synchronized OkHttpClient getOkHttpClient(){
        if(okHttpClient==null){
            //创建拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("reg", message);
                }
            });
            //设置拦截爱情
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
        }
        return okHttpClient;
    }
    //网络请求
    public  void doGet(String url, Callback callback) {

        OkHttpClient okHttpClient = getOkHttpClient();
        //请求方式
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public  void doPost(String url, Map<String, String> map, Callback callback) {
        OkHttpClient okHttpClient = getOkHttpClient();
        FormBody.Builder formBody = new FormBody.Builder();
        for (String key : map.keySet() ) {
            formBody.add(key,map.get(key));
        }
        //请求方式
        Request request = new Request.Builder().url(url).post(formBody.build()).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

}
