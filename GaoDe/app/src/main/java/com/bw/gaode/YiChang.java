package com.bw.gaode;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * @author xuhongtao
 * @fileName YiChang
 * @package com.bw.gaode
 * @date 2019/3/3/003 20:55
 */
public class YiChang implements Thread.UncaughtExceptionHandler {
    private Context mcontext;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;


    private static YiChang yiChang;

    private YiChang() {
    }

    public static YiChang getYiChang() {
        if (yiChang == null) {
            synchronized (YiChang.class) {
                if (yiChang == null) {
                    yiChang = new YiChang();
                }
            }
        }
        return yiChang;
    }

    public void init(Context context) {
        mcontext = context;
        uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e == null) {
            uncaughtExceptionHandler.uncaughtException(t, e);
        }else{
            new Thread() {// 在主线程中弹出提示
                @Override
                public void run() {
                    Looper.prepare();
                    Toast.makeText(mcontext, "捕获到异常", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }.start();

        }

    }
}
