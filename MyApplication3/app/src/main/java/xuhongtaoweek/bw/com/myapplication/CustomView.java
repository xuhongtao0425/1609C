package xuhongtaoweek.bw.com.myapplication;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author xuhongtao
 * @fileName CustomView
 * @package xuhongtaoweek.bw.com.myapplication
 * @date 2019/3/8/008 9:57
 */
public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    public CustomView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }
}
