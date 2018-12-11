package com.first_tv.IMainActivity.View.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.first_tv.IMainActivity.View.View.Fragment.bean.BjsonData;
import com.first_tv.IMainActivity.View.View.Fragment.codFragment;

public class CodAdatper extends BaseAdapter {

    private final BjsonData bjsonData;
    private final codFragment codFragment;

    public CodAdatper(codFragment codFragment, BjsonData bjsonData) {
        this.codFragment=codFragment;
        this.bjsonData=bjsonData;
    }

    @Override
    public int getCount() {
        return 0;
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
        return null;
    }
}