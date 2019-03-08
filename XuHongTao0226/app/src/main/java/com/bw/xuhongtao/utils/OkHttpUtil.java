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
 * @author xuhongtao
 * @fileName OkHttpUtil
 * @package com.bw.xuhongtao.utils
 * @date 2019/2/26/026 9:12
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
    /*
     *  封装OKHttp
     * */
    private static OkHttpClient okHttpClient;
    private static synchronized OkHttpClient getOkHttpClient(){
        if(okHttpClient==null){
            HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("lan",message);
                }
            });
//            设置拦截模式
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient=new OkHttpClient();
        }
        return okHttpClient;
    }
    /*
    * doGet
    * */
    public void doGet(String url, Callback callback){
        OkHttpClient okHttpClient = getOkHttpClient();
        //创建请求方式
        Request request=new Request.Builder().url(url).build();
        //执行请求方式
        okHttpClient.newCall(request).enqueue(callback);


    }  /*
    * doPost
    * */
    public void doPost(String url, Map<String ,String> map, Callback callback){
        OkHttpClient okHttpClient = getOkHttpClient();
        //创建请求体
        FormBody.Builder body=new FormBody.Builder();
        //取值
        for (String m:map.keySet()) {
            body.add(m,map.get(m));
        }
        //创建请求方式
        Request request=new Request.Builder().url(url).post(body.build()).build();
        //执行请求方式
        okHttpClient.newCall(request).enqueue(callback);


    }

}
