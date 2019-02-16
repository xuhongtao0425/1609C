package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtao.utils.OkHttpUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName ShowModel
 * @package com.bw.xuhongtao.model
 * @date 2019/2/15/015 20:14
 */
public class ShowModel {
    public interface OnShowListener{
        void showData( List<Bean.DataEntity> data);
    }
    private OnShowListener onShowListener;

    public void setOnShowListener(OnShowListener onShowListener) {
        this.onShowListener = onShowListener;
    }

    String url="http://www.xieast.com/api/news/news.php?page=1";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json= (String) msg.obj;
                    Gson gson=new Gson();
                    Bean bean = gson.fromJson(json, Bean.class);
                    List<Bean.DataEntity> data = bean.getData();
                    onShowListener.showData(data);
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
//                Log.i("rrr",json);
                Message message=new Message();
                message.what=0;
                message.obj=json;
                handler.sendMessage(message);
            }
        });
    }
}
