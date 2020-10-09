package com.jk.mvpdemo.mvp.modle;

import com.jk.mvpdemo.mvp.contract.MVP4Contract;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 18:50
 */
public class MVP4Model implements MVP4Contract.MVP4Model {
    @Override
    public void ModelRequest(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.qq.com/")
                .build();
        client.newCall(request).enqueue(callback);
    }
}
