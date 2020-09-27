package com.jk.mvpdemo.mvp.contract;

import com.jk.mvpdemo.mvp.basemvp.IBasePresenter;
import com.jk.mvpdemo.mvp.basemvp.IBaseView;

import okhttp3.Callback;

public interface MVP5Contract {

    interface MVP5Model{
        //modle 层请求数据
        void requestyData(Callback callback);
    }

    interface MVP5View extends IBaseView{
        //view 进行界面更新操作
        void showPrograssDialog();
        void dismissDialog();
        void onSuccess(String result);
        void onFailure(String errorStr);
    }

    interface MVP5Presenter extends IBasePresenter{
        //presenter 层进行数据的处理
        void handleData();
    }

}
