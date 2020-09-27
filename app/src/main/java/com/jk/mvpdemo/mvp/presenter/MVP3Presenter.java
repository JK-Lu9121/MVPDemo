package com.jk.mvpdemo.mvp.presenter;

import com.jk.mvpdemo.mvp.contract.MVP3Contract;
import com.jk.mvpdemo.mvp.modle.MVP3Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MVP3Presenter implements MVP3Contract.IPresenter{

    private MVP3Contract.IModel iModel;
    private MVP3Contract.IView iView;

    public MVP3Presenter(MVP3Contract.IView iView) {
        this.iView = iView;
        iModel = new MVP3Model();
    }

    //通知model层进行网络数据请求。
    // 并对请求回来的数据进行处理。
    @Override
    public void handleData() {

        if (iView != null){
            iView.showPrograssDialog();
        }

        iModel.requestyData(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //网络请求失败的回调
                if (iView != null){
                    iView.dismissDialog();
                    iView.onFailure(e.getMessage());
                }

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //网络请求成功的回调
                String result = response.body().string();
                if (iView != null){
                    iView.dismissDialog();
                    iView.onSuccess(result);
                }
            }
        });
    }
}
