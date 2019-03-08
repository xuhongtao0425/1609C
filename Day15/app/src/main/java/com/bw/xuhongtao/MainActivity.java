package com.bw.xuhongtao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

public class MainActivity extends AppCompatActivity {

    private MapView mv;
private AMap aMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv = findViewById(R.id.mv);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mv.onCreate(savedInstanceState);
        if(aMap==null){
             aMap = mv.getMap();

        }

    }

}
