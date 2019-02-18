package com.bw.xuhongtao.utils;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * @author xuhongtao
 * @fileName MyApp
 * @package com.bw.xuhongtao.utils
 * @date 2019/2/18/018 9:56
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        File file = new File(Environment.getExternalStorageDirectory(), "/imm");
        if (file.exists()) {
            file.mkdir();
        }
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .diskCache(new UnlimitedDiskCache(file))
                .diskCacheFileCount(100)
                .diskCacheSize(5 * 1024 * 1024)
                .build();
        ImageLoader.getInstance().init(configuration);
    }
}
