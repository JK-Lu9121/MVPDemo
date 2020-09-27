package com.jk.mvpdemo.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jk.mvpdemo.R;
import com.jk.mvpdemo.mvp.contract.MVP1Contract;
import com.jk.mvpdemo.mvp.presenter.MVP1Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVP1Activity extends AppCompatActivity implements MVP1Contract.IMVP1View, View.OnClickListener {

    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_request)
    Button btnRequest;

    private MVP1Presenter mvp1Presenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp1);
        ButterKnife.bind(this);

        btnRequest.setOnClickListener(this);

        mvp1Presenter = new MVP1Presenter(this);
        dialog = new ProgressDialog(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_request:
                mvp1Presenter.handleData();//网络请求数据
                break;
            default:
                break;
        }
    }

    //显示对话框
    @Override
    public void showDialog() {
        if (dialog != null){
            dialog.setMessage("正在请求数据");
            dialog.show();
        }
    }

    //关闭对话框
    @Override
    public void dissmissDiaLog() {
        if (dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    //成功的回调
    @Override
    public void OnSuccess(String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("请求结果为：" + result);
            }
        });


    }

    //失败的回调
    @Override
    public void OnFailue(String erroStr) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("请求结果为：" + erroStr);
            }
        });
    }

}