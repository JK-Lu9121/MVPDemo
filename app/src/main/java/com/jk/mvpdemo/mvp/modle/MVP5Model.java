package com.jk.mvpdemo.mvp.modle;

import com.jk.mvpdemo.mvp.contract.MVP5Contract;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MVP5Model implements MVP5Contract.MVP5Model {
    @Override
    public void requestyData(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.qq.com/")
                .build();
        client.newCall(request).enqueue(callback);//异步请求网络数据，
        // 因为在model层不做数据处理，所以传入一个callback将数据传入presenter层。
    }
}
