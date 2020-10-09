package com.jk.mvpdemo.mvp.contract;

import okhttp3.Callback;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 18:50
 */
public interface MVP4Contract {

    interface MVP4Model{
        void ModelRequest(Callback callback);
    }

    interface MVP4View{
        void showDialog();
        void dismissDialog();
        void onSuccess(String result);
        void onFailure(String errorStr);
    }

    interface MVP4Presenter{
        void DataRequest();
    }


}
