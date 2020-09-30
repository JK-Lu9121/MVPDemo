package com.jk.mvpdemo.mvp2.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected P mPresenter;

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);
    protected abstract void initData();
    protected abstract void initViews();
    protected abstract void initListener();
    protected abstract P setPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout(savedInstanceState);//实例化布局
        initData();//实例化相关数据
        initViews();//实例化相关控件
        initListener();//实例化相关监听

        /**
         * 实例化和绑定 P 层
         */
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

    /**
     * 获取上下文
     * @return
     */
    @Override
    public Context getContext() {
        return this;
    }
}
