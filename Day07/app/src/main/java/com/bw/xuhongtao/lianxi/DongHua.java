package com.bw.xuhongtao.lianxi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author xuhongtao
 * @fileName DongHua
 * @package com.bw.xuhongtao.lianxi
 * @date 2019/2/21/021 16:32
 */
public class DongHua extends TextView {
    public DongHua(Context context) {
        super(context);
    }

    public DongHua(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public DongHua(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        // 设置抗锯齿
        paint.setAntiAlias(true);
        // 设置画笔颜色
        paint.setColor(Color.RED);
        // 三种样式
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(5);
        canvas.drawCircle(50,50,50,paint);
    }
}
