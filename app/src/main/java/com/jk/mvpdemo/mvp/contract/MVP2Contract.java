package com.jk.mvpdemo.mvp.contract;

import okhttp3.Call;
import okhttp3.Callback;

public interface MVP2Contract {

    interface IMVP2Model{
        void requestData(Callback callback);
    }

    interface IMVP2View{
        void showDialog();
        void dissmissDialog();
        void onSuccess(String result);
        void onFailure(String errorStr);
    }

    interface IMVP2Presenter{
        void handleData();
    }

}
