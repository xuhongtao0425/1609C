package com.bw.Week2.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bw.Week2.R;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyListviewAdapter
 * @package com.bw.Week2.view.adapter
 * @date 2019/2/24/024 19:41
 */
public class MyListviewAdapter extends BaseAdapter {
    Context context;
    List<String> ls;

    public MyListviewAdapter(Context context, List<String> ls) {
        this.context = context;
        this.ls = ls;
    }

    @Override
    public int getCount() {
        return ls.size();
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
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.ls, null);
            viewHolder=new ViewHolder();
            viewHolder.textView=convertView.findViewById(R.id.text_ls);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(ls.get(position));
        return convertView;
    }

    class ViewHolder {
        private TextView textView;

    }
}
