package com.jk.mvpdemo.mvp4.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.jk.mvpdemo.R;
import com.jk.mvpdemo.mvp4.base.BaseActivity;
import com.jk.mvpdemo.mvp4.contract.MVP9Contract;
import com.jk.mvpdemo.mvp4.presenter.MVP9Preseter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create By JK_Liu on ${DATE}
 */
public class MVP9Activity extends BaseActivity<MVP9Contract.MVP9Presenter> implements View.OnClickListener, MVP9Contract.MVP9View {

    @BindView(R.id.btn_request)
    Button btnRequest;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private ProgressDialog dialog;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_mvp9);
        ButterKnife.bind(this);
    }

    @Override
    protected void iniData() {

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
    protected MVP9Contract.MVP9Presenter setPresenter() {
        return new MVP9Preseter();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_request:
                mPresenter.handleData();
                break;
            default:
                break;
        }
    }

    @Override
    public void showDialog() {
        if (dialog != null){
            dialog.setMessage("请稍后……");
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
}
