package com.bw.week.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.week.model.bean.PagerBean;
import com.bw.week.utils.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName PagerModel
 * @package com.bw.week.model
 * @date 2019/2/28/028 18:21
 */
public class PagerModel {
    public interface OnPagerModelListener{
        void  getData(List<PagerBean.ResultEntity> result);
    }
    private OnPagerModelListener onPagerModelListener;

    public void setOnPagerModelListener(OnPagerModelListener onPagerModelListener) {
        this.onPagerModelListener = onPagerModelListener;
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json=(String ) msg.obj;
                    Gson gson=new Gson();
                    PagerBean pagerBean = gson.fromJson(json, PagerBean.class);
                    List<PagerBean.ResultEntity> result = pagerBean.getResult();
                    if(onPagerModelListener!=null){
                        onPagerModelListener.getData(result);
                    }
                    break;
            }
        }
    };
    public void pagerModel() {
        OkHttpUtil.getOkHttpUtil().doGet("http://172.17.8.100/small/commodity/v1/bannerShow", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
//                Log.i("xxxx",json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);

            }
        });
    }
}
