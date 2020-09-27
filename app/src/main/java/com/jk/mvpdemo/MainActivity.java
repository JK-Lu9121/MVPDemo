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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tvTitle.setOnClickListener(this);
        btnMvc.setOnClickListener(this);
        btnMvp.setOnClickListener(this);
        btnMvp2.setOnClickListener(this);

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
            case R.id.btn_mvp:
                startActivity(new Intent(MainActivity.this, MVP1Activity.class));
                break;
            case R.id.btn_mvp2:
                startActivity(new Intent(MainActivity.this, MVP2Activity.class));
                break;
            default:
                break;
        }
    }
}