package com.bw.Day09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author xuhongtao
 * @fileName MyDonghua
 * @package com.bw.Day09
 * @date 2019/2/22/022 8:48
 */
public class MyDonghua extends TextView {
    public MyDonghua(Context context) {
        super(context);
    }

    public MyDonghua(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDonghua(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(100,100,50,paint);
    }
}
