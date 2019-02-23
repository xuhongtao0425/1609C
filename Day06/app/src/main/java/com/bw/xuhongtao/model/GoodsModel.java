package com.bw.xuhongtao.model;

import android.os.Handler;
import android.os.Message;

import com.bw.xuhongtao.utils.OkHttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName GoodsModel
 * @package com.bw.xuhongtao.model
 * @date 2019/2/19/019 9:07
 */
public class GoodsModel {
    //定义接口
    public interface OnGoodsLinston{
        void goodsData(JSONArray list,String message,String status);
    }
    private OnGoodsLinston onGoodsLinston;

    public void setOnGoodsLinston(OnGoodsLinston onGoodsLinston) {
        this.onGoodsLinston = onGoodsLinston;
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String goods=(String) msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(goods);
                        String message = jsonObject.getString("message");
                        String status = jsonObject.getString("status");
                        JSONArray result = jsonObject.getJSONArray("result");


                        if(onGoodsLinston!=null){
                            onGoodsLinston.goodsData(result,message,status);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };

private String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=高跟鞋&count=10";
    public void goodsModel(final int page) {
        OkHttpUtil.getOkHttpUtil().doGet(url+"&page="+page, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String goods = response.body().string();
                Message message=new Message();
                message.what=0;
                message.obj=goods;

                handler.sendMessage(message);


            }
        });
    }
}
