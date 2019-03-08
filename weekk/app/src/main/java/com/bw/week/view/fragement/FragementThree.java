package com.bw.week.view.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.bw.week.R;
import com.bw.week.view.activity.Main2Activity;
import com.bw.week.view.activity.MainActivity;

/**
 * @author xuhongtao
 * @fileName FragementThree
 * @package com.bw.week.view.fragement
 * @date 2019/3/2/002 8:39
 */
public class FragementThree extends Fragment {

    private WebView wv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.three, container, false);
        wv = view.findViewById(R.id.wv);
        wv.loadUrl("file:///android_asset/info.html");
//        wv.loadUrl("file:///android_asset/infos.html");
        //
        wv.getSettings().setJavaScriptEnabled(true);
        wv.addJavascriptInterface(this, "android");

        wv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("javascript:test()");
            }
        });
        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return false;
            }
        });
        return view;
    }

    @JavascriptInterface
    public void jump() {
        Toast.makeText(getActivity(), "用户名" , Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getActivity(), Main2Activity.class));

    }

}
