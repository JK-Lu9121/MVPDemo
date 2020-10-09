package com.jk.mvpdemo.mvp.presenter;

import com.jk.mvpdemo.mvp.contract.MVP4Contract;
import com.jk.mvpdemo.mvp.modle.MVP4Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 18:50
 */
public class MVP4Presenter implements MVP4Contract.MVP4Presenter {

    private MVP4Contract.MVP4View mvp4View;
    private MVP4Contract.MVP4Model mvp4Model;

    public MVP4Presenter(MVP4Contract.MVP4View mvp4View) {
        this.mvp4View = mvp4View;
        mvp4Model = new MVP4Model();
    }

    @Override
    public void DataRequest() {
        if (mvp4View != null){
            mvp4View.showDialog();
        }

        mvp4Model.ModelRequest(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                if (mvp4View != null){
                    mvp4View.dismissDialog();
                    mvp4View.onFailure(e.getMessage());
                }
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                if (mvp4View != null){
                    mvp4View.dismissDialog();
                    mvp4View.onSuccess(result);
                }
            }
        });

    }
}
