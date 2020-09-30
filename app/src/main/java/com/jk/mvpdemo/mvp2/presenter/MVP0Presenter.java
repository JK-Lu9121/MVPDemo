package com.jk.mvpdemo.mvp2.presenter;

import com.jk.mvpdemo.mvp2.contract.MVP0Contract;
import com.jk.mvpdemo.mvp2.model.MVP0Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MVP0Presenter implements MVP0Contract.MVP0Presenter {

    private MVP0Contract.MVP0View mvp0View;
    private MVP0Contract.MVP0Model mvp0Model;

    public MVP0Presenter(MVP0Contract.MVP0View mvp0View) {
        this.mvp0View = mvp0View;
        mvp0Model = new MVP0Model();
    }

    @Override
    public void handleData() {
        if (mvp0View != null){
            mvp0View.showDialog();
        }

        mvp0Model.dataRequest(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                if (mvp0View != null){
                    mvp0View.dismissDialog();
                    mvp0View.onFailure(e.getMessage());
                }
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                if (mvp0View != null){
                    mvp0View.dismissDialog();
                    mvp0View.onSuccess(result);
                }
            }
        });
    }
}
