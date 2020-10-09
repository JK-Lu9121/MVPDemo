package com.jk.mvpdemo.mvp3.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 19:12
 */
public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected P mPresenter;

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);
    protected abstract void initViews();
    protected abstract void initData();
    protected abstract void initListener();

    protected abstract P setPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout(savedInstanceState);
        initData();
        initViews();
        initListener();

        mPresenter = setPresenter();
        mPresenter.attach(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /**
         * 解绑，避免内存泄漏
         */
        mPresenter.detach();
        mPresenter = null;

    }

    @Override
    public Context getContext() {
        return this;
    }
}
