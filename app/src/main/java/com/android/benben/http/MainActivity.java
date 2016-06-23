package com.android.benben.http;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.benben.http.api.ApiService;
import com.android.benben.http.model.LoginResultBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.text)
    TextView text;
    private String TAG = "http";
    @InjectView(R.id.he_1)
    EditText he1;
    @InjectView(R.id.he_2)
    EditText he2;

    private String username, password;
    TelephonyManager mTelephoeyMgr;
    private List<UserInfo> mModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        username = he1.getText().toString().trim();
        password = he2.getText().toString().trim();
        mTelephoeyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3,})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Log.i(TAG, "111111111111111111111111111111111111111: ");
                startActivity(new Intent(MainActivity.this, CustomerActivity.class));
                break;
            case R.id.button2:
                loginl();
                break;
            case R.id.button3:
                login(username, password, mTelephoeyMgr.getDeviceId());
                break;
        }
    }

    private void loginl() {

    }


    private void login(String username, String password, String ims) {
        RetrofitBuilder
                .get()
                .create(ApiService.class)
                .login(username, password, ims)
                .enqueue(new Callback<LoginResultBean>() {
                    @Override
                    public void onResponse(Call<LoginResultBean> call, Response<LoginResultBean> response) {
                        Log.d("lyx", "=====================success======================" + response.toString());
                    }

                    @Override
                    public void onFailure(Call<LoginResultBean> call, Throwable t) {
                        Log.d("lyx", "=======================error=====================" + t.getMessage());
                        //请求网络  ，日志会把所有东西全部打印出来，连请求用了多少时间都有
                    }
                });
    }


}
