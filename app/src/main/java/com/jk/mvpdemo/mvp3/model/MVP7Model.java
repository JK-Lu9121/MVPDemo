package com.jk.mvpdemo.mvp3.model;

import com.jk.mvpdemo.mvp3.constract.MVP7Contract;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 19:36
 */
public class MVP7Model implements MVP7Contract.MVP7Model {
    @Override
    public void ModelRequest(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.qq.com/")
                .build();
        client.newCall(request).enqueue(callback);
    }
}
