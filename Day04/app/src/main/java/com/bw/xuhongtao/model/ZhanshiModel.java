package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;

import com.bw.xuhongtao.utils.OkHttpUtilss;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName ZhanshiModel
 * @package com.bw.xuhongtao.model
 * @date 2019/2/17/017 15:50
 */
public class ZhanshiModel {
    public interface OnZhanshiLinstn{
        void zhanshiData( List<Bean.DataEntity> data);
    }
    private OnZhanshiLinstn onZhanshiLinstn;

    public void setOnZhanshiLinstn(OnZhanshiLinstn onZhanshiLinstn) {
        this.onZhanshiLinstn = onZhanshiLinstn;
    }



    String url = "http://www.xieast.com/api/news/news.php?page=1";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String json = (String) msg.obj;
                    Gson gson=new Gson();
                    Bean bean = gson.fromJson(json, Bean.class);
                    List<Bean.DataEntity> data = bean.getData();
                    if(onZhanshiLinstn!=null){
                        onZhanshiLinstn.zhanshiData(data);
                    }
                    break;
            }
        }
    };

    public void zhanshiModel() {
        OkHttpUtilss.doGet(url, new Callback() {
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
