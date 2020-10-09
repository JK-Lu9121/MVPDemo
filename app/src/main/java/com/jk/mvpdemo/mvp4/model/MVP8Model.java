package com.jk.mvpdemo.mvp4.model;

import com.jk.mvpdemo.mvp4.contract.MVP8Contract;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 21:30
 */
public class MVP8Model implements MVP8Contract.MVP8Model {
    @Override
    public void ModelRequest(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.qq.com/")
                .build();
        client.newCall(request).enqueue(callback);
    }
}
