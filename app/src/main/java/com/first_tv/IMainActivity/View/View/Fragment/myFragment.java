package com.first_tv.IMainActivity.View.View.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.first_tv.R;

import org.w3c.dom.Text;


public class myFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView my_image;
    private TextView myname_textview,tv_xiugai,tv_yingxiao,tv_yingye,tv_shoucang,tv_guankan,tv_jiazhang;
    private Switch sw_jiazhang;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(),R.layout.fragment_my,null);
        my_image=view.findViewById(R.id.my_imageView);
        myname_textview=view.findViewById(R.id.myname_textView);
        tv_xiugai=view.findViewById(R.id.tv_xiugai);
        tv_yingxiao=view.findViewById(R.id.tv_yingxiao);
        tv_yingye=view.findViewById(R.id.tv_yingye);
        tv_shoucang=view.findViewById(R.id.tv_shoucang);
        tv_guankan=view.findViewById(R.id.tv_guankan);
        tv_jiazhang=view.findViewById(R.id.tv_jiazhang);
        sw_jiazhang=view.findViewById(R.id.sw_jiazhang);
        tv_xiugai.setOnClickListener(this);
        tv_yingxiao.setOnClickListener(this);
        tv_yingye.setOnClickListener(this);
        tv_shoucang.setOnClickListener(this);
        tv_guankan.setOnClickListener(this);
        sw_jiazhang.setOnClickListener(this);
        tv_jiazhang.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_xiugai:
                Toast.makeText(getActivity(),"修改",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_yingxiao:
                Toast.makeText(getActivity(),"手机营销",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_yingye:
                Toast.makeText(getActivity(),"电视营业厅",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_shoucang:
                Toast.makeText(getActivity(),"收藏",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_guankan:
                Toast.makeText(getActivity(),"观看记录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_jiazhang:
                Toast.makeText(getActivity(),"家长控制",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sw_jiazhang:
                Toast.makeText(getActivity(),"开启",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
