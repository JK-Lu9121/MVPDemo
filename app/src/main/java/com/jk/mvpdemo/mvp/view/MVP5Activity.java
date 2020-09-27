package com.jk.mvpdemo.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.jk.mvpdemo.MainActivity;
import com.jk.mvpdemo.R;
import com.jk.mvpdemo.mvp.basemvp.BaseActivity;
import com.jk.mvpdemo.mvp.contract.MVP5Contract;
import com.jk.mvpdemo.mvp.presenter.MVP5Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVP5Activity extends BaseActivity<MVP5Contract.MVP5Presenter> implements MVP5Contract.MVP5View, View.OnClickListener {

    @BindView(R.id.btn_request)
    Button btnRequest;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private ProgressDialog dialog;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_mvp5);
        ButterKnife.bind(this);
    }

    @Override
    protected void initViews() {
        dialog = new ProgressDialog(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btnRequest.setOnClickListener(this);
    }

    @Override
    protected MVP5Contract.MVP5Presenter setPresenter() {
        return new MVP5Presenter();
    }

    @Override
    public void showPrograssDialog() {
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
                tvResult.setText(result);
            }
        });
    }

    @Override
    public void onFailure(String errorStr) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText(errorStr);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_request:
                mPresenter.handleData();
                break;
            default:
                break;
        }
    }
}