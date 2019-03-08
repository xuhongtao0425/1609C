package com.bw.week.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.week.model.bean.LeiBiaoBean;
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
 * @fileName LeiBiaoModel
 * @package com.bw.week.model
 * @date 2019/3/2/002 9:06
 */
public class LeiBiaoModel {

    public interface OnLeiBiaoModelListener{
        void  getData(List<LeiBiaoBean.ResultEntity> result);
    }
    private OnLeiBiaoModelListener onLeiBiaoModelListener;

    public void setOnLeiBiaoModelListener(OnLeiBiaoModelListener onLeiBiaoModelListener) {
        this.onLeiBiaoModelListener = onLeiBiaoModelListener;
    }


    private String url="http://172.17.8.100/small/commodity/v1/findFirstCategory";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json=(String ) msg.obj;
                    Gson gson=new Gson();
                    LeiBiaoBean leiBiaoBean = gson.fromJson(json, LeiBiaoBean.class);
                    List<LeiBiaoBean.ResultEntity> result = leiBiaoBean.getResult();
                    if(onLeiBiaoModelListener!=null){
                        onLeiBiaoModelListener.getData(result);
                    }
                    break;
            }
        }
    };
    public void leibiaoModel() {
        OkHttpUtil.getOkHttpUtil().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
//            Log.i("leibaio",json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);

            }
        });
    }
}
