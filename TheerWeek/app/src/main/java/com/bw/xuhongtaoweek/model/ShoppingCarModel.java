package com.bw.xuhongtaoweek.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.xuhongtaoweek.model.bean.GoodName;
import com.bw.xuhongtaoweek.model.bean.ShoppingBean;
import com.bw.xuhongtaoweek.uilts.OkHttpUilt;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author xuhongtao
 * @fileName ShoppingCarModel
 * @package com.bw.xuhongtaoweek.model
 * @date 2019/3/7/007 18:20
 */
public class ShoppingCarModel {

    public interface OnShoppingCarModelListener{
        void getShoppingCarModelData( List<ShoppingBean.DataEntity> data);
    }
    private OnShoppingCarModelListener onShoppingCarModelListener;

    public void setShoppingCarModelListener(OnShoppingCarModelListener onShoppingCarModelListener) {
        this.onShoppingCarModelListener = onShoppingCarModelListener;
    }


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json=(String) msg.obj;
                    Gson gson=new Gson();
                    ShoppingBean shoppingBean = gson.fromJson(json, ShoppingBean.class);
                    List<ShoppingBean.DataEntity> data = shoppingBean.getData();
                    if(onShoppingCarModelListener!=null){
                        onShoppingCarModelListener.getShoppingCarModelData(data);
                    }

                    break;
            }
        }
    };


    private String url="http://172.17.8.100/ks/product/getCarts?uid=51";
    public void shoppingCarModel() {
        OkHttpUilt.getOkHttpUilt().doGet(url, null, null, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("json",json);
                Message message=new Message();
                message.what=0;
                message.obj=json;
                handler.sendMessage(message);
            }
        });
    }
}
