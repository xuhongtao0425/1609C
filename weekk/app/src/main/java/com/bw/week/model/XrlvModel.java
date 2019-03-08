package com.bw.week.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.week.model.bean.Bean;
import com.bw.week.model.bean.PagerBean;
import com.bw.week.model.bean.ShouYeBean;
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
 * @fileName XrlvModel
 * @package com.bw.week.model
 * @date 2019/2/28/028 20:31
 */
public class XrlvModel {
    public interface OnXrlvModelListener {
        void getData(Bean list);
    }

    private OnXrlvModelListener onXrlvModelListener;

    public void setOnXrlvModelListener(OnXrlvModelListener onXrlvModelListener) {
        this.onXrlvModelListener = onXrlvModelListener;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    List<Bean> list = new ArrayList<>();
                    String json = (String) msg.obj;
                    Gson gson = new Gson();
                    ShouYeBean bean = gson.fromJson(json, ShouYeBean.class);
                    ShouYeBean.ResultEntity result = bean.getResult();
                    ShouYeBean.ResultEntity.MlssEntity mlss = result.getMlss();
                    ShouYeBean.ResultEntity.PzshEntity pzsh = result.getPzsh();
                    ShouYeBean.ResultEntity.RxxpEntity rxxp = result.getRxxp();
                    Bean b = new Bean(mlss, pzsh, rxxp);
                    list.add(b);
                    Log.i("xuhongtao", list.toString());
                    if (onXrlvModelListener != null) {
                        onXrlvModelListener.getData(b);
                    }
                    break;
            }
        }
    };

    public void xrlvModel() {
        OkHttpUtil.getOkHttpUtil().doGet("http://172.17.8.100/small/commodity/v1/commodityList", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
//                Log.i("xxxx", json);
                Message message = new Message();
                message.what = 0;
                message.obj = json;
                handler.sendMessage(message);

            }
        });
    }
}
