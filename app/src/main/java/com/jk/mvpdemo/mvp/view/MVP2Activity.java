package com.jk.mvpdemo.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jk.mvpdemo.R;
import com.jk.mvpdemo.mvp.contract.MVP2Contract;
import com.jk.mvpdemo.mvp.presenter.MVP2Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVP2Activity extends AppCompatActivity implements View.OnClickListener, MVP2Contract.IMVP2View {

    @BindView(R.id.btn_request)
    Button btnRequest;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private MVP2Presenter mvp2Presenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp2);
        ButterKnife.bind(this);

        mvp2Presenter = new MVP2Presenter(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("正在请求数据");

        btnRequest.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_request:
                //网络请求
                mvp2Presenter.handleData();
                break;
            default:
                break;
        }
    }

    @Override
    public void showDialog() {
        if (dialog != null){
            dialog.show();
        }
    }

    @Override
    public void dissmissDialog() {
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