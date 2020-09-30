package com.jk.mvpdemo.mvp2.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jk.mvpdemo.R;
import com.jk.mvpdemo.mvp2.contract.MVP0Contract;
import com.jk.mvpdemo.mvp2.presenter.MVP0Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVP0Activity extends AppCompatActivity implements View.OnClickListener, MVP0Contract.MVP0View {

    @BindView(R.id.btn_request)
    Button btnRequest;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private ProgressDialog dialog;
    private MVP0Presenter mvp0Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp0);
        ButterKnife.bind(this);
        btnRequest.setOnClickListener(this);
        initView();
        mvp0Presenter = new MVP0Presenter(MVP0Activity.this);
    }

    private void initView() {
        dialog = new ProgressDialog(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_request:
                //数据请求
                mvp0Presenter.handleData();
                break;
            default:
                break;
        }
    }

    @Override
    public void showDialog() {
        if (dialog != null){
            dialog.setMessage("正在获取数据");
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