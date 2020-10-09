package com.jk.mvpdemo.mvp5.base;

public interface IBasePresenter<V extends IBaseView> {

    void attach(V view);
    void detach();

}
