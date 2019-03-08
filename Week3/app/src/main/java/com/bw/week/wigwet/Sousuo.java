package com.bw.week.wigwet;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bw.week.R;


/**
 * @author yaoqi
 * @fileName Sousuo
 * @package com.bw.yq.wigwet
 * @date 2019/2/27 21:26
 */
public class Sousuo extends LinearLayout {

    private EditText sou;
    private ImageView img, bt;

    public interface OnSousuoListenter {
        void OnSta(String sou);
    }

    public OnSousuoListenter sousuoListenter;

    public void setOnSousuoListenter(OnSousuoListenter sousuoListenter) {
        this.sousuoListenter = sousuoListenter;
    }

    public interface OnErweimaListenter {
        void OnEewei();
    }

    public OnErweimaListenter erweimaListenter;

    public void setOnErweimaListenter(OnErweimaListenter erweimaListenter) {
        this.sousuoListenter = sousuoListenter;
    }

    public Sousuo(Context context) {

        super(context);
    }

    public Sousuo(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.sousuo, null, false);
        addView(view);
        img = view.findViewById(R.id.er);
        sou = view.findViewById(R.id.sou);
        bt = view.findViewById(R.id.bt);
    }

    public Sousuo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
