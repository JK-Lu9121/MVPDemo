package com.jk.mvpdemo.mvp2.model;

import com.jk.mvpdemo.mvp2.contract.MVP6Contract;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MVP6Model implements MVP6Contract.MVP6Model {
    @Override
    public void dataRequest(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.toutiao.com/")
                .build();
        client.newCall(request).enqueue(callback);
    }
}
