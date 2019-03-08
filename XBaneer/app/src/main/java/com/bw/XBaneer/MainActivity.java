package com.bw.XBaneer;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.XBaneer.utils.OkHttpUtil;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private XBanner xBanner;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        JSONArray result = jsonObject.getJSONArray("result");
                        final List<String> list = new ArrayList<>();
                        for (int i = 0; i < result.length(); i++) {
                            JSONObject jsonObject1 = result.getJSONObject(i);
                            String imageUrl = jsonObject1.getString("imageUrl");
                            list.add(imageUrl);
                        }
                        xBanner.setData(list, null);
                        xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                            @Override
                            public void loadBanner(XBanner banner, Object model, View view, int position) {
                                Glide.with(MainActivity.this).load(list.get(position)).into((ImageView) view);
                            }
                        });
//                        xBanner.setPageTransformer(Transformer.Default);//横向移动

//                        xBanner.setPageTransformer(Transformer.Alpha); //渐变，效果不明显
//
//                        xBanner.setPageTransformer(Transformer.Rotate);  //单页旋转
//
//                        xBanner.setPageTransformer(Transformer.Cube);    //立体旋转
//
//                        xBanner.setPageTransformer(Transformer.Flip);  // 反转效果
//
//                        xBanner.setPageTransformer(Transformer.Accordion); //三角换页
//
                        xBanner.setPageTransformer(Transformer.ZoomFade); // 缩小本页，同时放大另一页
//
//                        xBanner.setPageTransformer(Transformer.ZoomCenter); //本页缩小一点，另一页就放大
//
//                        xBanner.setPageTransformer(Transformer.ZoomStack); // 本页和下页同事缩小和放大
//
//                        xBanner.setPageTransformer(Transformer.Stack);  //本页和下页同时左移
//
//                        xBanner.setPageTransformer(Transformer.Depth);  //本页左移，下页从后面出来
//
//                        xBanner.setPageTransformer(Transformer.Zoom);  //本页刚左移，下页就在后面

                        xBanner.setPageChangeDuration(500);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xBanner = findViewById(R.id.xbanner);
        //网络请求图片
        OkHttpUtil.getOkHttpUtil().doGet("http://172.17.8.100/small/commodity/v1/bannerShow", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);

            }
        });

    }
}
