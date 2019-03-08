package com.bw.xuhongtao.utils;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * @author xuhongtao
 * @fileName MyException
 * @package com.bw.xuhongtao.utils
 * @date 2019/3/4/004 10:03
 */
public class MyException implements Thread.UncaughtExceptionHandler {
    private Context mcontext;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;


    private static MyException myException;

    private MyException() {
    }

    public static MyException getMyException() {
        if (myException == null) {
            synchronized (MyException.class) {
                if (myException == null) {
                    myException = new MyException();
                }
            }
        }
        return myException;
    }

    public void init(Context context) {
        mcontext = context;
        uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e == null) {
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(t, e);
            }
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    Toast.makeText(mcontext, "捕获到异常了", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }).start();
        }

    }
}
