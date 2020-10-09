package com.jk.mvpdemo.mvp3.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.jk.mvpdemo.R;
import com.jk.mvpdemo.mvp3.base.BaseActivity;
import com.jk.mvpdemo.mvp3.constract.MVP7Contract;
import com.jk.mvpdemo.mvp3.presenter.MVP7Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create By JK_Liu on ${DATE}
 */
public class MVP7Activity extends BaseActivity<MVP7Contract.MVP7Presenter> implements View.OnClickListener,MVP7Contract.MVP7View {

    @BindView(R.id.btn_request)
    Button btnRequest;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private ProgressDialog dialog;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_mvp7);
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
    protected MVP7Contract.MVP7Presenter setPresenter() {
        return new MVP7Presenter();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_request:
                mPresenter.handlerData();
                break;
            default:
                break;
        }
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
}
