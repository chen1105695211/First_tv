package com.first_tv.IMainActivity.View.Model;

import okhttp3.OkHttpClient;

public class B_Okhttp {
    //创建OkhttpClient实例，Google官方文档指明，不希望存在多个OkhttpClient实例，造成复用，浪费资源。所以此处我们应该使用单例模式.
    private static OkHttpClient okHttpClient=new OkHttpClient();
    public static OkHttpClient getClient(){
        return okHttpClient;
    }

}

