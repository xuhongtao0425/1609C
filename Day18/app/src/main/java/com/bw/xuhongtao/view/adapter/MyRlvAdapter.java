package com.bw.xuhongtao.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.xuhongtao.R;
import com.bw.xuhongtao.view.adapter.widget.JaJianQi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhongtao
 * @fileName MyRlvAdapter
 * @package com.bw.xuhongtao.view.adapter
 * @date 2019/3/5/005 11:04
 */
public class MyRlvAdapter extends RecyclerView.Adapter {
    Context context;
    JSONArray result;
    Map<String, Boolean> map = new HashMap<>();
    int zongjia = 0;


    public MyRlvAdapter(Context context, JSONArray result) {
        this.result = result;
        this.context = context;
        nosetData(false);
    }

    public void noChecked(boolean frag) {
        if (frag) {
            for (int j = 0; j < result.length(); j++) {
                try {
                    String price = result.getJSONObject(j).getString("price");
                    int ss = Integer.parseInt(price);
                    zongjia += ss;
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            if (onSumsListener != null) {
                onSumsListener.onCheck(zongjia);
            }

        }else{
            zongjia=0;
            if (onSumsListener != null) {
                onSumsListener.onCheck(zongjia);
            }
        }

        nosetData(frag);
        notifyDataSetChanged();
    }


    public void nosetData(boolean frag) {
        map.clear();
        for (int i = 0; i < result.length(); i++) {
            try {
                JSONObject jsonObject = result.getJSONObject(i);
                String id = jsonObject.getString("commodityId");
                map.put(id, frag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        try {
            String commodityName = result.getJSONObject(i).getString("commodityName");
            final String price = result.getJSONObject(i).getString("price");
            String masterPic = result.getJSONObject(i).getString("masterPic");
            final String id = result.getJSONObject(i).getString("commodityId");
            ((ViewHolder) viewHolder).name_item.setText(commodityName);
            ((ViewHolder) viewHolder).privce_item.setText("¥" + price);
            Glide.with(context).load(masterPic).into(((ViewHolder) viewHolder).image_item);


            ((ViewHolder) viewHolder).checked_item.setChecked(map.get(id));
            ((ViewHolder) viewHolder).checked_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final boolean checked = ((ViewHolder) viewHolder).checked_item.isChecked();
                    map.put(id, checked);
                    boolean frag = true;
                    for (String key : map.keySet()) {
                        Boolean fra = map.get(key);
                        if (!fra) {
                            frag = false;
                            if (onCheckListener != null) {
                                onCheckListener.onCheck(frag);
                            }
                        } else {
                            if (onCheckListener != null) {
                                onCheckListener.onCheck(frag);
                            }

                        }
                    }

                    //条目点击总价
                    if (checked) {
                        int num = ((ViewHolder) viewHolder).num_item.num();
                        int prices = Integer.parseInt(price);
                        if (onSumListener != null) {
                            onSumListener.onCheck(prices * num);
                        }
                    } else {
                        if (onSumListener != null) {
                            onSumListener.onCheck(0);
                        }
                    }


                }
            });
            //加减器
            ((ViewHolder) viewHolder).num_item.setOnNumListener(new JaJianQi.onNumListener() {
                @Override
                public void getNumData(int num) {
                    for (String key : map.keySet()) {
                        Boolean fra = map.get(key);
                        if (fra) {
                            int prices = Integer.parseInt(price);
                            if (onjiasumListener != null) {
                                onjiasumListener.onCheck(num * prices);

                            }
                        }

                    }

                }


            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return result.length();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final JaJianQi num_item;
        private TextView privce_item, name_item;
        private final ImageView image_item;
        private final CheckBox checked_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            num_item = itemView.findViewById(R.id.num_item);
            privce_item = itemView.findViewById(R.id.privce_item);
            name_item = itemView.findViewById(R.id.name_item);
            image_item = itemView.findViewById(R.id.image_item);
            checked_item = itemView.findViewById(R.id.checked_item);
        }
    }

    public interface OnCheckListener {
        void onCheck(boolean frag);
    }

    private OnCheckListener onCheckListener;

    public void setOnCheckListener(OnCheckListener onCheckListener) {
        this.onCheckListener = onCheckListener;
    }

    //复选框总价
    public interface OnSumListener {
        void onCheck(int sum);
    }

    private OnSumListener onSumListener;

    public void setOnSumListener(OnSumListener onSumListener) {
        this.onSumListener = onSumListener;
    }

    //全选总价
    public interface OnSumsListener {
        void onCheck(int sum);
    }

    private OnSumsListener onSumsListener;

    public void setOnSumsListener(OnSumsListener onSumsListener) {
        this.onSumsListener = onSumsListener;
    }

    //加减器总价
    public interface OnjiaSumListener {
        void onCheck(int sum);
    }

    private OnjiaSumListener onjiasumListener;

    public void setOnjiaSumListener(OnjiaSumListener OnjiasumListener) {
        this.onjiasumListener = OnjiasumListener;
    }
}
