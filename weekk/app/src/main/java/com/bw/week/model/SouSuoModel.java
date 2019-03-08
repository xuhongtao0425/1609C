package com.bw.week.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.week.model.bean.Bean;
import com.bw.week.model.bean.ShouYeBean;
import com.bw.week.model.bean.SouSuoBean;
import com.bw.week.utils.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName SouSuoModel
 * @package com.bw.week.model
 * @date 2019/3/1/001 20:11
 */
public class SouSuoModel {
    public interface OnSouSuoModelListener {
        void getData(List<SouSuoBean.ResultEntity> result);
    }

    private OnSouSuoModelListener onSouSuoModelListener;

    public void setOnXrlvModelListener(OnSouSuoModelListener onSouSuoModelListener) {
        this.onSouSuoModelListener = onSouSuoModelListener;
    }
    private String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?count=10";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                   Gson gson=new Gson();
                    SouSuoBean souSuoBean = gson.fromJson(json, SouSuoBean.class);
                    List<SouSuoBean.ResultEntity> result = souSuoBean.getResult();
                    if(onSouSuoModelListener!=null){
                        onSouSuoModelListener.getData(result);
                    }
                    break;
            }
        }
    };
    public void sousuoModel(int page, String name) {
        OkHttpUtil.getOkHttpUtil().doGet(url + "&page=" + page + "&keyword=" + name, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("xxxx", json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);
            }
        });
    }
}
