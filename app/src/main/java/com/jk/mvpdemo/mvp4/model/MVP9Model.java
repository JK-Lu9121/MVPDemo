package com.jk.mvpdemo.mvp4.model;

import com.jk.mvpdemo.mvp4.contract.MVP9Contract;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 21:50
 */
public class MVP9Model implements MVP9Contract.MVP9Model {
    @Override
    public void DataRequest(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();
        client.newCall(request).enqueue(callback);
    }
}
