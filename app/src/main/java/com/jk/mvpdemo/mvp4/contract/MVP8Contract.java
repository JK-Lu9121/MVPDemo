package com.jk.mvpdemo.mvp4.contract;

import com.jk.mvpdemo.mvp4.base.IBasePresenter;
import com.jk.mvpdemo.mvp4.base.IBaseView;

import okhttp3.Callback;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 21:21
 */
public interface MVP8Contract {

    interface MVP8Model{
        void ModelRequest(Callback callback);
    }

    interface MVP8View extends IBaseView {
        void showDialog();
        void dismissDialog();
        void onSuccess(String result);
        void onFailure(String errorStr);
    }

    interface MVP8Presenter extends IBasePresenter{
        void DataRequest();
    }

}
