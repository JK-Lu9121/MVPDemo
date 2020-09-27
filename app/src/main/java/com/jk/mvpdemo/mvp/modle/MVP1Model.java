package com.jk.mvpdemo.mvp.modle;

import com.jk.mvpdemo.mvp.contract.MVP1Contract;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Model 的具体实现类，去实现Contract 接口
 */
public class MVP1Model implements MVP1Contract.IMVP1Model {

    /**
     * 网络请求写在这
     * @param callback
     */
    @Override
    public void RequestData(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();
        client.newCall(request).enqueue(callback);//异步请求网络
    }
}
