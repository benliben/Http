package com.android.benben.http;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.benben.http.api.ApiService;
import com.android.benben.http.model.CustomerBean;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LiYuanxiong on 2016/6/20 8:49.
 * Desribe:
 */
public class CustomerActivity extends Activity {
    @InjectView(R.id.customer_content)
    RecyclerView mContent;
    long id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        ButterKnife.inject(this);
        initView();
        id = getIntent().getLongExtra("id", 0);
        initData(id);
    }

    private void initData(long id) {
        RetrofitBuilder.get()
                .create(ApiService.class)
                .customer(id)
                .enqueue(new Callback<CustomerBean>() {
                    @Override
                    public void onResponse(Call<CustomerBean> call, Response<CustomerBean> response) {
                        Log.d("lyx", "=====================success======================" + response.toString());
                    }

                    @Override
                    public void onFailure(Call<CustomerBean> call, Throwable t) {
                        Log.d("lyx", "=======================error=====================" + t.getMessage());
                    }
                });
    }

    private void initView() {

    }
}
