package com.bw.Week2.view.fragement;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bw.Week2.R;
import com.bw.Week2.view.base.BaseFragement;
import com.jwkj.libzxing.OnQRCodeScanCallback;
import com.jwkj.libzxing.QRCodeManager;

/**
 * @author xuhongtao
 * @fileName FragementOne
 * @package com.bw.Week2.view.fragement
 * @date 2019/2/23/023 10:18
 */
public class FragementTwo extends BaseFragement implements View.OnClickListener {

    private Button budai, dai, s;
    private ImageView imageView;

    @Override
    protected int layoutResID() {
        return R.layout.fragementtwo;
    }

    @Override
    protected void initView(View view) {
        budai = view.findViewById(R.id.bd);
        dai = view.findViewById(R.id.dai);
        s = view.findViewById(R.id.s);
        imageView = view.findViewById(R.id.ima);
        budai.setOnClickListener(this);
        dai.setOnClickListener(this);
        s.setOnClickListener(this);


    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bd:
                Bitmap bitmap2 = QRCodeManager.getInstance().createQRCode("不努力背井离乡你为了啥", 200, 200);
                imageView.setImageBitmap(bitmap2);
                break;
            case R.id.dai:
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.common);
                Bitmap bitmap1 = QRCodeManager.getInstance().createQRCode("不努力背井离乡你为了啥", 200, 200, bitmap);
                imageView.setImageBitmap(bitmap1);
                break;
            case R.id.s:
                QRCodeManager.getInstance().with(getActivity()).scanningQRCode(new OnQRCodeScanCallback() {
                    @Override
                    public void onCompleted(String s) {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onCancel() {

                    }
                });
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QRCodeManager.getInstance().with(getActivity()).onActivityResult(requestCode,resultCode,data);
    }
}
