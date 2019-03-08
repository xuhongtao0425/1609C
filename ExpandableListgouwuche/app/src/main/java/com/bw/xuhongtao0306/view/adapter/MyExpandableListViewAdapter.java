package com.bw.xuhongtao0306.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.xuhongtao0306.R;
import com.bw.xuhongtao0306.model.bean.Data;
import com.bw.xuhongtao0306.model.bean.Datas;
import com.bw.xuhongtao0306.view.activity.MainActivity;
import com.bw.xuhongtao0306.view.widget.JaJianQi;

import java.util.List;

/**
 * @author xuhongtao
 * @fileName MyExpandableListViewAdapter
 * @package com.bw.xuhongtao0306.view.adapter
 * @date 2019/3/6/006 13:42
 */
public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {
    Context context;
    List<Data> data;

    public MyExpandableListViewAdapter(Context context, List<Data> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getSpus().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getSpus().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final ViewHloder viewHloder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.oneview, null, false);
            viewHloder = new ViewHloder();
            //找控件
            viewHloder.titlt = convertView.findViewById(R.id.title_oneview);
            viewHloder.checkBox = convertView.findViewById(R.id.checkbox_oneview);

            convertView.setTag(viewHloder);
        } else {
            viewHloder = (ViewHloder) convertView.getTag();
        }

        //赋值
        viewHloder.titlt.setText(data.get(groupPosition).getName());
        viewHloder.checkBox.setChecked(data.get(groupPosition).isChecked());

        viewHloder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = viewHloder.checkBox.isChecked();

                if (ononeviewListener != null) {
                    ononeviewListener.getoneviewData(checked,groupPosition);
                }
            }
        });
        return convertView;

    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ViewHloder2 viewHloder2;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.towview, null, false);
            viewHloder2 = new ViewHloder2();
            //找控件
            viewHloder2.name = convertView.findViewById(R.id.name_towview);
            viewHloder2.tiem = convertView.findViewById(R.id.tiem_towview);
            viewHloder2.price = convertView.findViewById(R.id.price_towview);
            viewHloder2.checkbox = convertView.findViewById(R.id.checkbox_towview);
            viewHloder2.imageView = convertView.findViewById(R.id.image_towview);
            viewHloder2.jiajianqi_towview = convertView.findViewById(R.id.jiajianqi_towview);
            convertView.setTag(viewHloder2);
        } else {
            viewHloder2 = (ViewHloder2) convertView.getTag();
        }
        //获取子条目对象
        Datas datas = data.get(groupPosition).getSpus().get(childPosition);
        viewHloder2.name.setText(datas.getName());
        viewHloder2.tiem.setText(datas.getCreated_at());
        viewHloder2.price.setText("¥:" + datas.getPraise_num());
        viewHloder2.checkbox.setChecked(datas.isItemChecked());
        Glide.with(context).load(datas.getPic_url()).into(viewHloder2.imageView);

        // //二级复选框点击事件
        viewHloder2.checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                boolean checked = viewHloder2.checkbox.isChecked();
                if(ontowviewListener!=null){
                    ontowviewListener.gettowviewData(checked,groupPosition,childPosition);
                }
            }
        });


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHloder {
        TextView titlt;
        CheckBox checkBox;
    }

    class ViewHloder2 {
        TextView name, tiem, price;
        CheckBox checkbox;
        ImageView imageView;
        JaJianQi jiajianqi_towview;
    }

    //一级选中控制全选
    public interface OnoneviewListener {
        void getoneviewData(boolean frag,int groudid);
    }

    private OnoneviewListener ononeviewListener;

    public void setOnoneviewListener(OnoneviewListener ononeviewListener) {
        this.ononeviewListener = ononeviewListener;
    }

    //二级选中控制一级和全选
    public interface OntowviewListener {
        void gettowviewData(boolean frag,int group,int child);
    }

    private OntowviewListener ontowviewListener;

    public void settowviewListener(OntowviewListener ontowviewListener) {
        this.ontowviewListener = ontowviewListener;
    }
}
