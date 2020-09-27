package com.jk.mvpdemo.mvp.contract;

import okhttp3.Callback;

/**
 * 契约接口类,定义存放三方（Model、View、Presenter）接口。
 */
public interface MVP1Contract {

    interface IMVP1Model{
        void RequestData(Callback callback);
    }

    interface IMVP1View{
        void showDialog();
        void dissmissDiaLog();
        void OnSuccess(String result);
        void OnFailue(String erroStr);
    }

    interface IMVP1Presenter{
        void handleData();
    }

}
