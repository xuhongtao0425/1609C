package com.bw.Week2.utils;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author xuhongtao
 * @fileName OkHttpUtil
 * @package com.bw.Week2.utils
 * @date 2019/2/22/022 19:03
 */
public class OkHttpUtil {

    //单列模式
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

    //okhttp
    private static OkHttpClient okHttpClient = null;

    public static synchronized OkHttpClient getOkHttpClient() {
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

    //doGet
    public void doGet(String url, Callback callback) {
        OkHttpClient okHttpClient = getOkHttpClient();
        //请求方式
        Request request = new Request.Builder().url(url).build();
        //执行
        okHttpClient.newCall(request).enqueue(callback);
    }

}
