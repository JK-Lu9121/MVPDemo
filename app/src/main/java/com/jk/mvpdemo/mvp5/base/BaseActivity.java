package com.jk.mvpdemo.mvp5.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {


    protected abstract void initLayout(@Nullable Bundle savedInstanceState);
    protected abstract void initData();
    protected abstract void initViews();
    protected abstract void initListener();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout(savedInstanceState);
        initData();
        initViews();
        initListener();

    }

    @Override
    public Context getContext() {
        return this;
    }
}
