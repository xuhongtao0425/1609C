package com.bw.Day09;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhengsr.viewpagerlib.bean.PageBean;
import com.zhengsr.viewpagerlib.view.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itm);

        BannerViewPager bannerViewPager = findViewById(R.id.bviewpager);
        int [] ima={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4};
        final List<ImageView> list=new ArrayList<>();
        for (int i = 0; i < ima.length; i++) {
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(ima[i]);
            list.add(imageView);

        }
        bannerViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view==o;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = list.get(position);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });
    }
}
