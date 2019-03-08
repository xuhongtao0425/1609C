package com.bw.xuhongtao.view.fragement;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.bw.xuhongtao.R;

/**
 * @author xuhongtao
 * @fileName FragementOne
 * @package com.bw.xuhongtao.view.fragement
 * @date 2019/3/4/004 8:51
 */
public class FragementTwo extends Fragment {

    private Button js;
    private WebView wv;

    @SuppressLint("JavascriptInterface")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragementtwo, null, false);
        //控件
        js = view.findViewById(R.id.js);
        wv = view.findViewById(R.id.wv);
        //展示
//        wv.loadDataWithBaseURL(null,url,"text/html","utf-8",null);
        wv.loadUrl("file:///android_asset/onr.html");
        //执行
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //协议
        wv.addJavascriptInterface(this, "android");
        //允许
        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return false;
            }
        });
        //点击
        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("javascript:callJS()");

            }
        });

        return view;
    }
}
