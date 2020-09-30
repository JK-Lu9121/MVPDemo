package com.jk.mvpdemo.mvp2.model;

import com.jk.mvpdemo.mvp2.contract.MVP0Contract;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MVP0Model implements MVP0Contract.MVP0Model {
    @Override
    public void dataRequest(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.toutiao.com/")
                .build();
        client.newCall(request).enqueue(callback);
    }
}
