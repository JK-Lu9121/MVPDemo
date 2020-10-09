package com.jk.mvpdemo.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jk.mvpdemo.R;
import com.jk.mvpdemo.mvp.contract.MVP4Contract;
import com.jk.mvpdemo.mvp.presenter.MVP4Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create By JK_Liu on ${DATE}
 */
public class MVP4Activity extends AppCompatActivity implements View.OnClickListener, MVP4Contract.MVP4View {

    @BindView(R.id.btn_request)
    Button btnRequest;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private ProgressDialog dialog;
    private MVP4Presenter mvp4Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp4);
        ButterKnife.bind(this);

        btnRequest.setOnClickListener(this);
        dialog = new ProgressDialog(this);

        mvp4Presenter = new MVP4Presenter(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_request:
                //数据请求
                mvp4Presenter.DataRequest();
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
