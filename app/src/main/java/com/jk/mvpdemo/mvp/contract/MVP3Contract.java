package com.jk.mvpdemo.mvp.contract;

import okhttp3.Callback;

public interface MVP3Contract {

    interface IModel{
        void requestyData(Callback callback); //modle 层请求数据
    }

    interface IView{
        //view 进行界面更新操作
        void showPrograssDialog();
        void dismissDialog();
        void onSuccess(String result);
        void onFailure(String errorStr);
    }

    interface IPresenter{
        //presenter 层进行数据的处理
        void handleData();
    }


}
