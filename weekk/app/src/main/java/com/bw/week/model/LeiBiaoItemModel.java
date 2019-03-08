package com.bw.week.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.week.model.bean.LeiBiaoBean;
import com.bw.week.model.bean.LeiBiaoTwoBean;
import com.bw.week.utils.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName LeiBiaoItemModel
 * @package com.bw.week.model
 * @date 2019/3/2/002 9:59
 */
public class LeiBiaoItemModel {
    public interface OnLeiBiaoItemModelListener{
        void  getData(  List<LeiBiaoTwoBean.ResultEntity> result );
    }
    private OnLeiBiaoItemModelListener onLeiBiaoItemModelListener;

    public void setOnLeiBiaoItemModelListener(OnLeiBiaoItemModelListener onLeiBiaoItemModelListener) {
        this.onLeiBiaoItemModelListener = onLeiBiaoItemModelListener;
    }
    private String url="http://172.17.8.100/small/commodity/v1/findSecondCategory?firstCategoryId=";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json=(String ) msg.obj;
                    Gson gson=new Gson();
                    LeiBiaoTwoBean leiBiaoTwoBean = gson.fromJson(json, LeiBiaoTwoBean.class);
                    List<LeiBiaoTwoBean.ResultEntity> result = leiBiaoTwoBean.getResult();
                    if(onLeiBiaoItemModelListener!=null){
                        onLeiBiaoItemModelListener.getData(result);
                    }

                    break;
            }
        }
    };
    public void itemModel(String id) {
        OkHttpUtil.getOkHttpUtil().doGet(url + id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
//                Log.i("leibaio",json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);

            }
        });

    }
}
