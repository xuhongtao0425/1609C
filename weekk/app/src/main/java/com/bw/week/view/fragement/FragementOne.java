package com.bw.week.view.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.week.R;
import com.bw.week.model.bean.Bean;
import com.bw.week.model.bean.PagerBean;
import com.bw.week.model.bean.SouSuoBean;
import com.bw.week.persenter.PagerPersenter;
import com.bw.week.persenter.SouSuoPersenter;
import com.bw.week.persenter.XrlvPersenter;
import com.bw.week.view.PagerView;
import com.bw.week.view.SouSuoView;
import com.bw.week.view.XrlvView;
import com.bw.week.view.adapter.MyVpAdapter;
import com.bw.week.view.adapter.MyXrlvAdapter;
import com.bw.week.view.adapter.Xrlv2Adapter;
import com.bw.week.view.wigwet.SouSuo;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jwkj.libzxing.OnQRCodeScanCallback;
import com.jwkj.libzxing.QRCodeManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName FragementOne
 * @package com.bw.week.view.fragement
 * @date 2019/2/28/028 17:43
 */
public class FragementOne extends Fragment implements PagerView, XrlvView,SouSuoView {

    private SouSuo souSuo;
    private ViewPager viewPager;
    private RecyclerView xrlv;
    private XRecyclerView xrlv2;
    private PagerPersenter persenter;
    private XrlvPersenter xrlvPersenter;
    private LinearLayoutManager layoutManager;
    private LinearLayoutManager layoutManager1;
    private SouSuoPersenter souSuoPersenter;
    private int page=1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one, container, false);
        souSuo = view.findViewById(R.id.sousuo);
        viewPager = view.findViewById(R.id.viewpage);
        xrlv = view.findViewById(R.id.xrlv);
        xrlv2 = view.findViewById(R.id.rlv2);



        layoutManager1 = new LinearLayoutManager(getActivity());
        xrlv2.setLayoutManager(layoutManager1);


        //实例化
        persenter = new PagerPersenter(this);
        xrlvPersenter = new XrlvPersenter(this);
        souSuoPersenter = new SouSuoPersenter(this);
        //管理
        persenter.attchData(this);
        xrlvPersenter.attchData(this);
        souSuoPersenter.attchData(this);
        //搜索
        souSuo.setOnSousuoListener(new SouSuo.OnSousuoListener() {
            @Override
            public void getData(String name) {
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(getActivity(), "内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                xrlv2.setVisibility(View.VISIBLE);
                xrlv.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                souSuoPersenter.suosouPersenter(page,name);

            }
        });
        //扫描
        souSuo.setOnSaoMiaoListener(new SouSuo.OnSaoMiaoListener() {
            @Override
            public void getData() {
                QRCodeManager.getInstance().setReqeustType(0).with(getActivity()).scanningQRCode(new OnQRCodeScanCallback() {
                    @Override
                    public void onCompleted(String s) {
                        Toast.makeText(getContext(), "0000", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getContext(), "1111", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        //轮播图
        persenter.pagerPersenter();
        //展示
        xrlvPersenter.xrlvPersenter();
        return view;
    }

    @Override
    public void getData(List<PagerBean.ResultEntity> result) {
        List<ImageView> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            Glide.with(getActivity()).load(result.get(i).getImageUrl()).into(imageView);
            list.add(imageView);
        }
        viewPager.setAdapter(new MyVpAdapter(getActivity(), list));
    }


    //展示
    @Override
    public void getXrlvData(final Bean list) {

        if (list != null) {
            layoutManager = new LinearLayoutManager(getActivity());
            xrlv.setLayoutManager(layoutManager);
            xrlv.setAdapter(new MyXrlvAdapter(getActivity(), list));
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter.datachData();
        xrlvPersenter.datachData();
        souSuoPersenter.datachData();
    }

    @Override
    public void getSouSuoData(List<SouSuoBean.ResultEntity> result) {
        xrlv2.setAdapter(new Xrlv2Adapter(getActivity(),result));
    }
}
