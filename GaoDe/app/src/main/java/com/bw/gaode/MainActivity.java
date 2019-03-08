package com.bw.gaode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMapOptionsCreator;
import com.amap.api.maps.MapView;

public class MainActivity extends AppCompatActivity {
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        YiChang.getYiChang().init(this);
       TextView textView = findViewById(R.id.title);
       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.i("ssss",1/0+"");
           }
       });
//        mv.onCreate(savedInstanceState);
        //初始化定位
//        mLocationClient = new AMapLocationClient(getApplicationContext());
//设置定位回调监听
//        mLocationClient.setLocationListener(mLocationListener);
    }
}
