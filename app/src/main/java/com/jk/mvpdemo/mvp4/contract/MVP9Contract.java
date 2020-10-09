package com.jk.mvpdemo.mvp4.contract;

import com.jk.mvpdemo.mvp4.base.IBasePresenter;
import com.jk.mvpdemo.mvp4.base.IBaseView;

import okhttp3.Callback;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 21:48
 */
public interface MVP9Contract {

    interface MVP9Model{
        void DataRequest(Callback callback);
    }

    interface MVP9View extends IBaseView{
        void showDialog();
        void dismissDialog();
        void onSuccess(String result);
        void onFailure(String errorStr);
    }

    interface MVP9Presenter extends IBasePresenter{
        void handleData();
    }

}
