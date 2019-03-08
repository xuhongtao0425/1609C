package com.bw.week.view.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.week.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Map;

/**
 * @author xuhongtao
 * @fileName FragementOne
 * @package com.bw.week.view.fragement
 * @date 2019/2/28/028 17:43
 */
public class FragementTwo extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two, container, false);
        view.findViewById(R.id.login).setOnClickListener(this);
        view.findViewById(R.id.reg).setOnClickListener(this);
        view.findViewById(R.id.yicahng).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                UMShareAPI umShareAPI = UMShareAPI.get(getActivity());
                //登录授权监听
                umShareAPI.getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
                break;
            case R.id.reg:
                //分享监听
                UMShareListener umShareListener = new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(SHARE_MEDIA platform) {
                        Log.d("plat", "platform" + platform);
                        Toast.makeText(getActivity(), platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA platform, Throwable t) {
                        Toast.makeText(getActivity(), platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                        Log.i("xxx", "onError: " + t);
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA platform) {
                        Toast.makeText(getActivity(), platform + " 分享取消了", Toast.LENGTH_SHORT).show();
                    }
                };
                //友盟图片
                UMImage umImage = new UMImage(getActivity(), R.mipmap.ic_launcher);
                new ShareAction(getActivity())
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(umImage)//分享图片
                        .setCallback(umShareListener)//回调监听器
                        .share();
                break;
            case R.id.yicahng:

                String a = null;
                String b = a.toString();
                Log.i("xxx", b);
                break;
        }
    }
}
