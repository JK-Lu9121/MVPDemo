package com.jk.mvpdemo.mvp4.presenter;

import com.jk.mvpdemo.mvp4.base.BasePresenter;
import com.jk.mvpdemo.mvp4.base.IBaseView;
import com.jk.mvpdemo.mvp4.contract.MVP8Contract;
import com.jk.mvpdemo.mvp4.model.MVP8Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 21:32
 */
public class MVP8Presenter extends BasePresenter<MVP8Contract.MVP8View> implements MVP8Contract.MVP8Presenter {

    private MVP8Contract.MVP8Model mvp8Model;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        mvp8Model = new MVP8Model();
    }

    @Override
    public void detach() {
        super.detach();
    }

    @Override
    public void DataRequest() {
        if (getView() != null){
            getView().showDialog();
        }

        mvp8Model.ModelRequest(new Callback() {
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
