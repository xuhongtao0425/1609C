package com.bw.xuhongtao.utils;

/**
 * @author xuhongtao
 * @fileName OkHttpUtils
 * @package com.bw.xuhongtao.utils
 * @date 2019/2/16/016 8:21
 */
public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;

    private OkHttpUtils() {
    }
    public static OkHttpUtils getOkHttpUtils(){
        if(okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if(okHttpUtils==null){
                    okHttpUtils=new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
}
