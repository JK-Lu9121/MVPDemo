package com.jk.mvpdemo.mvp4.base;

import android.view.View;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 21:19
 */
public interface IBasePresenter<V extends IBaseView> {

    void attach(V view);
    void detach();

}
