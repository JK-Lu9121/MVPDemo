package com.jk.mvpdemo.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jk.mvpdemo.R;
import com.jk.mvpdemo.mvp.contract.MVP3Contract;
import com.jk.mvpdemo.mvp.presenter.MVP3Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVP3Activity extends AppCompatActivity implements View.OnClickListener, MVP3Contract.IView {

    @BindView(R.id.btn_request)
    Button btnRequest;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private ProgressDialog dialog;
    private MVP3Presenter mvp3Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp3);
        ButterKnife.bind(this);

        btnRequest.setOnClickListener(this);
        mvp3Presenter = new MVP3Presenter(this);
        dialog = new ProgressDialog(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_request:
                mvp3Presenter.handleData();
                break;
            default:
                break;
        }
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
}