package com.jk.mvpdemo.mvp2.base;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {

    protected V mView;

    @Override
    public void attach(IBaseView view) {
        mView = (V) view; //向下转型
    }

    @Override
    public void detach() {
        mView = null;
    }
}
