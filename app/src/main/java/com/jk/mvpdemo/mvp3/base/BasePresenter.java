package com.jk.mvpdemo.mvp3.base;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 19:26
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter{

    protected V mView;

    @Override
    public void attach(IBaseView view) {
        mView = (V) view;
    }

    @Override
    public void detach() {
        mView = null;
    }
}
