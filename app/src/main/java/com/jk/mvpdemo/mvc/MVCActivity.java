package com.jk.mvpdemo.mvc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jk.mvpdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVCActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_request)
    Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        ButterKnife.bind(this);

        btnRequest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_request:
                Toast.makeText(MVCActivity.this,"Data Request",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}