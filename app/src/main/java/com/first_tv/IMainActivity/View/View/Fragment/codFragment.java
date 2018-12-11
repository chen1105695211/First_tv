package com.first_tv.IMainActivity.View.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.first_tv.IMainActivity.View.Presenter.codPersenter;
import com.first_tv.IMainActivity.View.View.Fragment.bean.BjsonData;
import com.first_tv.IMainActivity.View.adapter.CodAdatper;
import com.first_tv.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class codFragment extends Fragment implements View.OnClickListener, IChannelList {
    private View view;
    private boolean tag = false;
    private ListView cod_listView;
    private HorizontalScrollView cod_scrollview;
    private ImageView cod_image;
    private codPersenter codPersenter;
    private Context context;
    private static String TAG = "codFragment";
    public Gson gson;
    public BjsonData bjsonData;
    public BjsonData.CatalogListBean cataData;
    private List<String> list;
    //AllChannel url
    private String url = "http://webepg.test.itv.cn/api/ContentList?checkkey=0x201307151500&oid=1&pt=1&dt=2" +
            "&lg=chinese&tz=-480&ec=1&cc=1&hs=0&mc=1&dvb=1&tp=1&version=321.0.0.0w&u=n_1_p_1_lz0128_74a6eb53-796c-48c3-8a26-0f520412e67d_20181029" +
            "&id=1826&skip=0&limit=0";
    //菜单列表 URL
    private String oneurl = "http://webepg.test.itv.cn/api/Catalog?checkkey=0x201307151500&oid=1&pt=1&dt=2" +
            "&lg=chinese&tz=-480&ec=1&cc=1&hs=0&mc=1&dvb=1&tp=1&version=321.0.0.0w" +
            "&u=n_1_p_1_lz0128_74a6eb53-796c-48c3-8a26-0f520412e67d_20181029&id=1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_cod, null);
        context = getActivity();
        cod_listView = view.findViewById(R.id.cod_listView);
        cod_scrollview = view.findViewById(R.id.cod_scrollview);
        cod_image = view.findViewById(R.id.cod_image);
        cod_image.setOnClickListener(this);
//        cod_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
//        cod_scrollview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//            }
//        });
        //实例化Persenter 将上下文和api传入，再调用中间件的getGetUrl方法传入uri
        codPersenter = new codPersenter(this, this);
        codPersenter.getGeturl(oneurl);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cod_image:
                if (tag == true) {
                    tag = false;
                    cod_scrollview.setVisibility(View.GONE);
                } else {
                    tag = true;
                    cod_scrollview.setVisibility(View.VISIBLE);
//                    codPersenter.getGeturl(oneurl);
//                    Toast.makeText(getActivity(), "请求", Toast.LENGTH_SHORT).show();
//                    CodAdatper codAdatper = new CodAdatper(this, bjsonData);

                }
                break;
        }
    }

    @Override
    public void Isuccend(String string) {
        gson = new Gson();
        bjsonData = gson.fromJson(string, BjsonData.class);
        cataData = gson.fromJson(string, BjsonData.CatalogListBean.class);
        List<BjsonData.CatalogListBean> listName = bjsonData.getCatalogList();
        list = new ArrayList<>();
        for (int i = 0; i < listName.size(); i++) {
            list.add(listName.get(i).getName());
        }
        LinearLayout linearLayout = new LinearLayout(getActivity());
        for (int i = 0; i < list.size(); i++) {
            Button button = new Button(getActivity());
            button.setId(i);
            button.setText(list.get(i));
            Log.i(TAG, "。。。123。。。" + button.getText());

        }
        cod_scrollview.addView(linearLayout);
//        Log.i(TAG, "。。。菜单信息。。。。。。" + list);
    }

    @Override
    public void Ifail(String string) {
        System.out.print(string);
    }
}
