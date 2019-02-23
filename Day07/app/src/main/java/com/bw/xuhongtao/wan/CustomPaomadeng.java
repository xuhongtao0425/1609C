package com.bw.xuhongtao.wan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Random;

/**
 * @author xuhongtao
 * @fileName CustomPaomadeng
 * @package com.bw.xuhongtao
 * @date 2019/2/20/020 18:03
 */
public class CustomPaomadeng extends TextView {
    //定义一个X轴的起始值
    private float textX = 0;
    private Thread thread = null;
    private Paint paint;
    private boolean runing = true;

    public CustomPaomadeng(Context context) {
        super(context);
    }

    public CustomPaomadeng(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomPaomadeng(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔
        paint = new Paint();
//        paint.setColor(Color.RED);
        paint.setTextSize(30);
        //设置文字
        canvas.drawText("温室的花,死的块", textX, 50, paint);
        if (thread == null) {
            thread = new MyThread();
            thread.start();
        }

    }

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (runing) {
                textX = textX + 7;
                if (textX > getWidth()) {
                    //获取文字的长度
                    textX = 0 - paint.measureText("温室的花,死的块");
                }
                //重新设定文字
                postInvalidate();
                try {
                    //让子线程睡一会
                    sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    protected void onDetachedFromWindow() {
        runing = false;
        super.onDetachedFromWindow();

    }
}
