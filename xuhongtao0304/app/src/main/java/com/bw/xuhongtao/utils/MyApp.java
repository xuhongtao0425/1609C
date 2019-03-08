package com.bw.xuhongtao.utils;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * @author xuhongtao
 * @fileName MyApp
 * @package com.bw.xuhongtao.utils
 * @date 2019/3/4/004 10:12
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MyException.getMyException().init(this);
        UMConfigure.init(this,"5a12384aa40fa3551f0001d1","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
}
