package com.jk.mvpdemo.mvp2.contract;

import com.jk.mvpdemo.mvp2.base.IBasePresenter;
import com.jk.mvpdemo.mvp2.base.IBaseView;

import okhttp3.Callback;

public interface MVP6Contract {

    interface MVP6Model{
        void dataRequest(Callback callback);
    }

    interface MVP6View extends IBaseView{
        void showDialog();
        void dismissDialog();
        void onSuccess(String result);
        void onFailure(String errorStr);
    }

    interface MVP6Presenter extends IBasePresenter{
        void handlerData();
    }

}
