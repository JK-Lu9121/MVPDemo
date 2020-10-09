package com.jk.mvpdemo.mvp3.base;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 19:18
 */
public interface IBasePresenter<V extends IBaseView> {
    void attach(V view);
    void detach();
}
