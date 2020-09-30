package com.jk.mvpdemo.mvp2.presenter;

import com.jk.mvpdemo.mvp2.base.BasePresenter;
import com.jk.mvpdemo.mvp2.base.IBaseView;
import com.jk.mvpdemo.mvp2.contract.MVP6Contract;
import com.jk.mvpdemo.mvp2.model.MVP6Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MVP6Presenter extends BasePresenter<MVP6Contract.MVP6View> implements MVP6Contract.MVP6Presenter {

    private MVP6Contract.MVP6Model mvp6Model;

    @Override
    public void attach(IBaseView view) {
        super.attach(view);
        mvp6Model = new MVP6Model();
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

        mvp6Model.dataRequest(new Callback() {
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
