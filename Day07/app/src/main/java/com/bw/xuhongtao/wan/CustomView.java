package com.bw.xuhongtao.wan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author xuhongtao
 * @fileName CustomView
 * @package com.bw.xuhongtao
 * @date 2019/2/20/020 15:08
 */
public class CustomView extends TextView {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔
        Paint paint=new Paint();
        //设置抗矩形齿
        paint.setAntiAlias(true);
        //设置画笔颜色
        paint.setColor(Color.RED);
        //设置样式
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //设置画笔的宽度
        paint.setStrokeWidth(10);

        float[] pts = { 50, 50, 100, 100, 200, 200, 300, 300, 0, 100, 100, 0 };

        canvas.drawPoints(pts, paint);

    }
}
