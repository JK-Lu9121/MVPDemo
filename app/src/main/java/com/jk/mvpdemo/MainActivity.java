package com.jk.mvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jk.mvpdemo.mvc.MVCActivity;
import com.jk.mvpdemo.mvp.view.MVP1Activity;
import com.jk.mvpdemo.mvp.view.MVP2Activity;
import com.jk.mvpdemo.mvp.view.MVP3Activity;
import com.jk.mvpdemo.mvp.view.MVP4Activity;
import com.jk.mvpdemo.mvp.view.MVP5Activity;
import com.jk.mvpdemo.mvp2.ui.MVP0Activity;
import com.jk.mvpdemo.mvp2.ui.MVP6Activity;
import com.jk.mvpdemo.mvp3.ui.MVP7Activity;
import com.jk.mvpdemo.mvp4.ui.MVP8Activity;
import com.jk.mvpdemo.mvp4.ui.MVP9Activity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_mvc)
    Button btnMvc;
    @BindView(R.id.btn_mvp)
    Button btnMvp;
    @BindView(R.id.btn_mvp2)
    Button btnMvp2;
    @BindView(R.id.btn_mvp3)
    Button btnMvp3;
    @BindView(R.id.btn_mvp4)
    Button btnMvp4;
    @BindView(R.id.btn_mvp5)
    Button btnMvp5;
    @BindView(R.id.btn_mvp0)
    Button btnMvp0;
    @BindView(R.id.btn_mvp6)
    Button btnMvp6;
    @BindView(R.id.btn_mvp7)
    Button btnMvp7;
    @BindView(R.id.btn_mvp8)
    Button btnMvp8;
    @BindView(R.id.btn_mvp9)
    Button btnMvp9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tvTitle.setOnClickListener(this);
        btnMvc.setOnClickListener(this);
        btnMvp.setOnClickListener(this);
        btnMvp2.setOnClickListener(this);
        btnMvp3.setOnClickListener(this);
        btnMvp4.setOnClickListener(this);
        btnMvp5.setOnClickListener(this);
        btnMvp0.setOnClickListener(this);
        btnMvp6.setOnClickListener(this);
        btnMvp7.setOnClickListener(this);
        btnMvp8.setOnClickListener(this);
        btnMvp9.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_title:
                Log.e("123", "This is a MVP Demo");
                Toast.makeText(MainActivity.this, "This is a MVP Demo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_mvc:
                startActivity(new Intent(MainActivity.this, MVCActivity.class));
                break;
            case R.id.btn_mvp0:
                startActivity(new Intent(MainActivity.this, MVP0Activity.class));
                break;
            case R.id.btn_mvp:
                startActivity(new Intent(MainActivity.this, MVP1Activity.class));
                break;
            case R.id.btn_mvp2:
                startActivity(new Intent(MainActivity.this, MVP2Activity.class));
                break;
            case R.id.btn_mvp3:
                startActivity(new Intent(MainActivity.this, MVP3Activity.class));
                break;
            case R.id.btn_mvp4:
                startActivity(new Intent(MainActivity.this, MVP4Activity.class));
                break;
            case R.id.btn_mvp5:
                startActivity(new Intent(MainActivity.this, MVP5Activity.class));
                break;
            case R.id.btn_mvp6:
                startActivity(new Intent(MainActivity.this, MVP6Activity.class));
                break;
            case R.id.btn_mvp7:
                startActivity(new Intent(MainActivity.this, MVP7Activity.class));
                break;
            case R.id.btn_mvp8:
                startActivity(new Intent(MainActivity.this, MVP8Activity.class));
                break;
            case R.id.btn_mvp9:
                startActivity(new Intent(MainActivity.this, MVP9Activity.class));
                break;
            default:
                break;
        }
    }
}