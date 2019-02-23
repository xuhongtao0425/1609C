package com.bw.xuhongtao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bw.xuhongtao.MainActivity;
import com.bw.xuhongtao.R;

import java.util.ArrayList;

/**
 * @author xuhongtao
 * @fileName MyAdapter
 * @package com.bw.xuhongtao.adapter
 * @date 2019/2/20/020 8:54
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> list;
    public MyAdapter(Context context, ArrayList<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        ViewHolder viewHolder=new ViewHolder();
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item,null);
            viewHolder=new ViewHolder();
            viewHolder.textView=convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position));
        return convertView;
    }
    class ViewHolder{

        private TextView textView;
    }

}
