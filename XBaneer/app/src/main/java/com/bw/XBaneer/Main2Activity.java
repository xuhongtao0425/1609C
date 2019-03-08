package com.bw.XBaneer;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.XBaneer.utils.OkHttpUtil;
import com.bw.XBaneer.utils.ScaleAlphaPageTransformer;
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

public class Main2Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    int item = viewPager.getCurrentItem()+1;
                    viewPager.setCurrentItem(item);
                    handler.sendEmptyMessageDelayed(1, 1000);

                    break;

                case 0:
                    String json = (String) msg.obj;
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        JSONArray result = jsonObject.getJSONArray("result");
                        list = new ArrayList<>();
                        for (int i = 0; i < result.length(); i++) {
                            JSONObject jsonObject1 = result.getJSONObject(i);
                            String imageUrl = jsonObject1.getString("imageUrl");
                            list.add(imageUrl);
                        }
                        for (int i = 0; i < list.size(); i++) {
                            ImageView imageView = new ImageView(Main2Activity.this);
                            Glide.with(Main2Activity.this).load(list.get(i)).into(imageView);
                            imageViews.add(imageView);
                        }
                        //适配器
                        viewPager.setAdapter(new PagerAdapter() {
                            @Override
                            public int getCount() {
                                return Integer.MAX_VALUE;
                            }

                            @Override
                            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                                return o == view;
                            }

                            @NonNull
                            @Override
                            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                                position = position % imageViews.size();
                                ImageView imageView = imageViews.get(position);
                                container.addView(imageView);
                                return imageView;
                            }

                            @Override
                            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                                container.removeView((View) object);
                            }
                        });
                        handler.sendEmptyMessageDelayed(1, 1000);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };
    private List<String> list;
    private List<ImageView> imageViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewPager = findViewById(R.id.viewpage);
        //实例化自定义自定义工具类
        ScaleAlphaPageTransformer scaleAlphaPageTransformer = new ScaleAlphaPageTransformer();
        scaleAlphaPageTransformer.setType(true, true);

        viewPager.setPageTransformer(true, scaleAlphaPageTransformer);

        viewPager.setCurrentItem(2);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
