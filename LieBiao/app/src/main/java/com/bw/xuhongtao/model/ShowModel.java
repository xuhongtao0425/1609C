package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtao.model.bean.Bean;
import com.bw.xuhongtao.utils.OkHttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName ShowModel
 * @package com.bw.xuhongtao.model
 * @date 2019/2/16/016 8:15
 */
public class ShowModel {
    //定义接口
    public interface OnShowListener{
        void  getShowData(List<Bean.DataEntity> data);
    }
    private OnShowListener onShowListener;

    public void setOnShowListener(OnShowListener onShowListener) {
        this.onShowListener = onShowListener;
    }

    private String url = "http://www.xieast.com/api/news/news.php?page=1";
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
                    //回调参数
                    onShowListener.getShowData(data);
                    break;
            }
        }
    };

    public void showModel() {
        OkHttpUtils.doGet(url, new Callback() {
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
