package com.bw.xuhongtao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bw.xuhongtao.R;
import com.bw.xuhongtao.activity.MainActivity;
import com.bw.xuhongtao.bean.Data;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyXlistviewAdapter
 * @package com.bw.xuhongtao.adapter
 * @date 2019/2/14/014 9:03
 */
public class MyXlistviewAdapter extends BaseAdapter {
    Context context;
    List<Data.DataEntity> data1;
    private static final int ITEM_TYPE = 0;
    private static final int ITEM_TYPE1 = 1;

    public MyXlistviewAdapter(Context context, List<Data.DataEntity> data1) {
        this.context = context;
        this.data1 = data1;
    }

    @Override
    public int getItemViewType(int position) {

        if (position % 2 == 0) {
            return ITEM_TYPE1;
        } else {
            return ITEM_TYPE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return data1.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        ViewHolder1 viewHolder1 = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            if (type == ITEM_TYPE) {
                convertView = View.inflate(context, R.layout.item1, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = convertView.findViewById(R.id.text);
                convertView.setTag(viewHolder);
            }
            if (type == ITEM_TYPE1) {
                convertView = View.inflate(context, R.layout.item2, null);
                viewHolder1 = new ViewHolder1();
                viewHolder1.textView = convertView.findViewById(R.id.text);
                viewHolder1.imageView = convertView.findViewById(R.id.ima);
                convertView.setTag(viewHolder1);
            }
        } else {
            if (type == ITEM_TYPE) {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if (type == ITEM_TYPE1) {
                viewHolder1 = (ViewHolder1) convertView.getTag();
            }
        }
        if (type == ITEM_TYPE) {
            viewHolder.textView.setText(data1.get(position).getTitle());
        }
        if (type == ITEM_TYPE1) {
            viewHolder1.textView.setText(data1.get(position).getTitle());
            ImageLoader.getInstance().displayImage(data1.get(position).getThumbnail_pic_s(), viewHolder1.imageView);
        }
        return convertView;
    }

    class ViewHolder {
        private TextView textView;
    }

    class ViewHolder1 {
        private TextView textView;
        private ImageView imageView;
    }

}
