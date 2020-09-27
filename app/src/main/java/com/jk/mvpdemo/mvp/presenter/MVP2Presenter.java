package com.jk.mvpdemo.mvp.presenter;

import com.jk.mvpdemo.mvp.contract.MVP2Contract;
import com.jk.mvpdemo.mvp.modle.MVP2Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MVP2Presenter implements MVP2Contract.IMVP2Presenter {

    private MVP2Contract.IMVP2Model imvp2Model;
    private MVP2Contract.IMVP2View imvp2View;

    public MVP2Presenter(MVP2Contract.IMVP2View imvp2View) {
        this.imvp2View = imvp2View;
        imvp2Model = new MVP2Model();
    }


    @Override
    public void handleData() {
        if (imvp2View != null){
            imvp2View.showDialog();
        }

        imvp2Model.requestData(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                if (imvp2View != null){
                    imvp2View.dissmissDialog();
                    imvp2View.onFailure(e.getMessage());
                }
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                String result = response.body().string();
                if (imvp2View != null){
                    imvp2View.dissmissDialog();
                    imvp2View.onSuccess(result);
                }
            }
        });


    }
}
