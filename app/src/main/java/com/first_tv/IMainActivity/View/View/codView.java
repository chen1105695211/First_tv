package com.first_tv.IMainActivity.View.View;

import android.graphics.Bitmap;

//视图接口层，与视图进行数据传输的接口
public interface codView {
    void getView(String s);
    void postView(String s);
    void imgView(Bitmap bitmap);
}
