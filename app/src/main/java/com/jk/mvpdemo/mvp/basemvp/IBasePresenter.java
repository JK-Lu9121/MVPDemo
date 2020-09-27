package com.jk.mvpdemo.mvp.basemvp;

public interface IBasePresenter<V extends IBaseView> {

    void attach(V view); //presenter 绑定view
    void detach(); //presenter 解绑view(防止内存泄漏)

}
