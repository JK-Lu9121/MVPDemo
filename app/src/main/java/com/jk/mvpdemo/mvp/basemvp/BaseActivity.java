package com.jk.mvpdemo.mvp.basemvp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected P mPresenter;

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);

    protected abstract void initViews();

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract P setPresenter();

    //todo 这是一个findviewbyId 的通用写法吧，暂时不用。
    protected <T extends View> T $(@IdRes int viewId) {
        return findViewById(viewId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout(savedInstanceState);

        mPresenter = setPresenter();
        mPresenter.attach(this);

        initData();//实例化数据
        initViews();//实例化相关空间
        initListener();//实例化相关监听

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 解绑view,防止内存泄漏
         */
        mPresenter.detach();
        mPresenter = null;
    }

    @Override
    public Context getContex() {
        return this;
    }
}
