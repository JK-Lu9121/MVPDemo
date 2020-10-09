package com.jk.mvpdemo.mvp3.constract;

import com.jk.mvpdemo.mvp3.base.IBasePresenter;
import com.jk.mvpdemo.mvp3.base.IBaseView;

import okhttp3.Callback;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 19:30
 */
public interface MVP7Contract {

    interface MVP7Model{
        void ModelRequest(Callback callback);
    }

    interface MVP7View extends IBaseView {
        void showDialog();
        void dismissDialog();
        void onSuccess(String result);
        void onFailure(String errorStr);
    }

    interface MVP7Presenter extends IBasePresenter{
        void handlerData();
    }
}
