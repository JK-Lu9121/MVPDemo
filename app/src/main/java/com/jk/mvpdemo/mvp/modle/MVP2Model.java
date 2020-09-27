package com.jk.mvpdemo.mvp.modle;

import com.jk.mvpdemo.mvp.contract.MVP2Contract;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MVP2Model implements MVP2Contract.IMVP2Model {
    @Override
    public void requestData(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.qq.com/")
                .build();
        client.newCall(request).enqueue(callback);
    }
}
