package com.bw.Week2.view.fragement;

import android.os.Handler;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.Week2.R;
import com.bw.Week2.model.bean.Bean;
import com.bw.Week2.persenter.GoodsPersenter;
import com.bw.Week2.view.GoodsView;
import com.bw.Week2.view.adapter.MyListviewAdapter;
import com.bw.Week2.view.adapter.MyXrlvAdapter;
import com.bw.Week2.view.base.BaseFragement;
import com.bw.Week2.view.widget.CustomShouSuoKuang;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongtao
 * @fileName FragementOne
 * @package com.bw.Week2.view.fragement
 * @date 2019/2/23/023 10:18
 */
public class FragementOne extends BaseFragement implements GoodsView {

    private CustomShouSuoKuang cssk;
    private XRecyclerView xrlv;
    private GoodsPersenter persenter;
    //分页
    private int page = 1;

    private String name1 = "板鞋";

    private List<Bean.ResultEntity> list = null;

    private Handler handler = new Handler();
    private ListView listView;
    private LinearLayout lsjl;
    private List<String> ls=new ArrayList<>();
    private EditText ev;

    @Override
    protected int layoutResID() {
        return R.layout.fragementone;
    }

    @Override
    protected void initView(View view) {
        cssk = view.findViewById(R.id.cssk);
        listView = view.findViewById(R.id.listview);
        xrlv = view.findViewById(R.id.xrlv);
      listView = view.findViewById(R.id.listview);
        lsjl = view.findViewById(R.id.lsjl);


        ev = cssk.findViewById(R.id.ev);
        ev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lsjl.setVisibility(View.VISIBLE);

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        xrlv.setLayoutManager(layoutManager);
        xrlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //实例化GoodsPersenter
        persenter = new GoodsPersenter(FragementOne.this);


    }

    @Override
    protected void initData() {
        //管理
        persenter.attachView(FragementOne.this);
        //关联
//        persenter.goodsPersenter(page, name1);
        //
        cssk.setOnCustomShouSuoKuangListener(new CustomShouSuoKuang.OnCustomShouSuoKuangListener() {
            @Override
            public void getData(String name) {
                ls.add(name);
                listView.setAdapter(new MyListviewAdapter(getActivity(),ls));
                lsjl.setVisibility(View.GONE);
                Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
                name1 = name;
                persenter.goodsPersenter(page, name1);

            }
        });
        xrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        persenter.goodsPersenter(page, name1);
                        xrlv.refreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                page++;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        persenter.goodsPersenter(page, name1);
                        xrlv.loadMoreComplete();
                    }
                }, 2000);

            }
        });


    }

    //回调数据
    @Override
    public void getData(List<Bean.ResultEntity> result) {
        if(result.isEmpty()){
            return;
        }else {
            //判断
            if (page == 1) {
                list = new ArrayList<>();
            }
            list.addAll(result);
            MyXrlvAdapter adapter = new MyXrlvAdapter(getActivity(), list);
            xrlv.setAdapter(adapter);
            xrlv.scrollToPosition(adapter.getItemCount() - (result.size() - 1));
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解除管理防止内存泄露
        persenter.datachView();
    }


}
