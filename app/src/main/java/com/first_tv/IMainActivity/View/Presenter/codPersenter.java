package com.first_tv.IMainActivity.View.Presenter;

import android.content.Context;
import android.util.Log;

import com.first_tv.IMainActivity.View.Model.ChanneLlist;
import com.first_tv.IMainActivity.View.Model.IcallBack;
import com.first_tv.IMainActivity.View.View.Fragment.IChannelList;
import com.first_tv.IMainActivity.View.View.Fragment.codFragment;

import java.util.Map;

public class codPersenter{
    private static String TAG = "codPersenter";
    private codFragment codFragment;
    private IChannelList iChannelList;
    public ChanneLlist channeLlist=ChanneLlist.getInstance();

    public codPersenter(com.first_tv.IMainActivity.View.View.Fragment.codFragment codFragment, IChannelList iChannelList){
        this.codFragment=codFragment;
        this.iChannelList=iChannelList;
    }

    public void getGeturl(String url){
        channeLlist.getSyncchronized(codFragment, url, new IcallBack() {
            @Override
            public void result(String s) {
                iChannelList.Isuccend(s);
                Log.i(TAG,"---------"+s);
            }
        });
    }
    public void getPosturl(String url, Map<String,String> map){

    }

}
