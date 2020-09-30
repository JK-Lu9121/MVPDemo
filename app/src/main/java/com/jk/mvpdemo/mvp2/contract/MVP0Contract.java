package com.jk.mvpdemo.mvp2.contract;

import okhttp3.Callback;

public interface MVP0Contract {

    interface MVP0Model{
        void dataRequest(Callback callback);
    }

    interface MVP0View{
        void showDialog();
        void dismissDialog();
        void onSuccess(String result);
        void onFailure(String errorStr);
    }

    interface MVP0Presenter{
        void handleData();
    }

}
