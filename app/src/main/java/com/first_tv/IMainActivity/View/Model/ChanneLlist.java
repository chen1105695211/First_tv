package com.first_tv.IMainActivity.View.Model;

import android.content.Context;
import android.util.Log;

import com.first_tv.IMainActivity.View.View.Fragment.codFragment;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ChanneLlist {

    private static String TAG ="ChanneLlist";
    private static ChanneLlist instance = new ChanneLlist();//创建单例
    public static ChanneLlist getInstance(){

        return instance;
    }
    public OkHttpClient okHttpClient=B_Okhttp.getClient();

    /**
     * 异步get请求
     * 使用icallBack接口传递返回数据
     * @param context
     * @param url
     * @param icallBack
     */
    public void getSyncchronized(final codFragment context, final String url, final IcallBack icallBack ){
        Request request=new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                icallBack.result(e.toString());
                Log.i(TAG,"++++++++++"+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    icallBack.result(response.body().string());
                    Log.i(TAG,"========"+response.toString());
                }else {
                    icallBack.result("get请求失败。");
                }
            }
        });
    }


    public void postMap(final Context context, final String url, final Map<String,String> map,final IcallBack icallBack){
        FormBody.Builder builder=new FormBody.Builder();
        if(map!=null){
            //增强for循环遍历
            for (Map.Entry<String,String> entry:map.entrySet()) {

            }
        }
        FormBody formBody=builder.build();
        final Request request=new Request.Builder().post(formBody).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                icallBack.result(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    icallBack.result(response.body().string());
                }else
                    icallBack.result("post请求失败。");
            }
        });
    }


}
