package com.jk.mvpdemo.mvp3.presenter;

import com.jk.mvpdemo.mvp3.base.BasePresenter;
import com.jk.mvpdemo.mvp3.base.IBaseView;
import com.jk.mvpdemo.mvp3.constract.MVP7Contract;
import com.jk.mvpdemo.mvp3.model.MVP7Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 19:39
 */
public class MVP7Presenter extends BasePresenter<MVP7Contract.MVP7View> implements MVP7Contract.MVP7Presenter {

    private MVP7Contract.MVP7Model mvp7Model;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        mvp7Model = new MVP7Model();
    }

    @Override
    public void detach() {
        super.detach();
    }

    @Override
    public void handlerData() {
        if (mView != null){
            mView.showDialog();
        }

        mvp7Model.ModelRequest(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                if (mView != null){
                    mView.dismissDialog();
                    mView.onFailure(e.getMessage());
                }
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                if (mView != null){
                    mView.dismissDialog();
                    mView.onSuccess(result);
                }
            }
        });

    }
}

