package com.jk.mvpdemo.mvp2.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.jk.mvpdemo.R;
import com.jk.mvpdemo.mvp2.base.BaseActivity;
import com.jk.mvpdemo.mvp2.contract.MVP6Contract;
import com.jk.mvpdemo.mvp2.presenter.MVP6Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVP6Activity extends BaseActivity<MVP6Contract.MVP6Presenter> implements MVP6Contract.MVP6View, View.OnClickListener {

    @BindView(R.id.btn_request)
    Button btnRequest;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private ProgressDialog dialog;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_mvp6);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {
        dialog = new ProgressDialog(this);
    }

    @Override
    protected void initListener() {
        btnRequest.setOnClickListener(this);
    }

    @Override
    protected MVP6Contract.MVP6Presenter setPresenter() {
        return new MVP6Presenter();
    }

    @Override
    public void showDialog() {
        if (dialog != null){
            dialog.setMessage("正在请求数据");
            dialog.show();
        }
    }

    @Override
    public void dismissDialog() {
        if (dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public void onSuccess(String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("请求结果为:" + result);
            }
        });
    }

    @Override
    public void onFailure(String errorStr) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("请求结果为:" + errorStr);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_request:
                mPresenter.handlerData();
                break;
            default:
                break;
        }
    }
}