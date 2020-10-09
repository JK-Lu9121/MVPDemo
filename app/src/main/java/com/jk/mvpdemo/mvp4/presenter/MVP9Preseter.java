package com.jk.mvpdemo.mvp4.presenter;

import com.jk.mvpdemo.mvp4.base.BasePresenter;
import com.jk.mvpdemo.mvp4.base.IBaseView;
import com.jk.mvpdemo.mvp4.contract.MVP9Contract;
import com.jk.mvpdemo.mvp4.model.MVP9Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 21:52
 */
public class MVP9Preseter extends BasePresenter<MVP9Contract.MVP9View> implements MVP9Contract.MVP9Presenter {

    private MVP9Contract.MVP9Model mvp9Model;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        mvp9Model = new MVP9Model();
    }

    @Override
    public void detach() {
        super.detach();
    }

    @Override
    public void handleData() {
        if (getView() != null){
            getView().showDialog();
        }

        mvp9Model.DataRequest(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                if (getView() != null){
                    getView().dismissDialog();
                    getView().onFailure(e.getMessage());
                }
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                if (getView() != null){
                    getView().dismissDialog();
                    getView().onSuccess(result);
                }
            }
        });
    }
}
