package com.jk.mvpdemo.mvp.basemvp;

public class BasePresenter<V extends IBaseView> implements IBasePresenter {

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
