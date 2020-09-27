package com.jk.mvpdemo.mvp.presenter;

import com.jk.mvpdemo.mvp.contract.MVP1Contract;
import com.jk.mvpdemo.mvp.modle.MVP1Model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Presenter 层会持有 Model 与 View 层的引用
 */
public class MVP1Presenter implements MVP1Contract.IMVP1Presenter {

    private MVP1Contract.IMVP1Model imvp1Model;
    private MVP1Contract.IMVP1View imvp1View;

    public MVP1Presenter(MVP1Contract.IMVP1View imvp1View) {
        this.imvp1View = imvp1View;
        imvp1Model = new MVP1Model(); //父类引用指向子类对象
    }

    @Override
    public void handleData() {

        /**
         * 【重点！！！！】
         * 网络请求是延时操作，避免网络请求过程中，用户现行关闭了页面】
         * 所以每次操作view 层的时候都要进行判空。
         */
        if (imvp1View != null){
            imvp1View.showDialog();
        }

        imvp1Model.RequestData(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //Okhttp3--->失败的回调
                if (imvp1View != null){
                    imvp1View.dissmissDiaLog();
                    imvp1View.OnFailue(e.getMessage());
                }
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //Okhttp3--->成功的回调
                String result = response.body().string();
                if (imvp1View != null){
                    imvp1View.dissmissDiaLog();
                    imvp1View.OnSuccess(result);
                }
            }
        });
    }
}
