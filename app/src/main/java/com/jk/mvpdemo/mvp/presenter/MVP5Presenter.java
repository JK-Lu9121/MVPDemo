package com.jk.mvpdemo.mvp.presenter;

import com.jk.mvpdemo.mvp.basemvp.BasePresenter;
import com.jk.mvpdemo.mvp.basemvp.IBaseView;
import com.jk.mvpdemo.mvp.contract.MVP5Contract;
import com.jk.mvpdemo.mvp.modle.MVP5Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MVP5Presenter extends BasePresenter<MVP5Contract.MVP5View> implements MVP5Contract.MVP5Presenter {

    private MVP5Contract.MVP5Model mvp5Model;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        mvp5Model = new MVP5Model();
    }

    @Override
    public void handleData() {
        if (mView != null){
            mView.showPrograssDialog();
        }

        mvp5Model.requestyData(new Callback() {
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

    @Override
    public void detach() {
        super.detach();
    }
}
