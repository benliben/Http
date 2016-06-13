package com.android.benben.http;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.benben.okhttputils.callback.StringCallback;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.MediaType;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.text)
    TextView text;
    private String TAG = "http";
    @InjectView(R.id.he_1)
    EditText he1;
    @InjectView(R.id.he_2)
    EditText he2;

    private List<UserInfo> mModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3,})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                post();
                break;
            case R.id.button2:
                postContent();
                break;
            case R.id.button3:
//                getUser();
                postString();
                break;
        }
    }

    private void postString() {
        String usearname=he1.getText().toString();
        String password=he2.getText().toString();
        String url = NetWork.HTTP_ROOT + NetWork.PHONE_LOGIN;
        OkHttpUtils.postString()
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf_8"))
                .content(new Gson().toJson(new User(usearname,password)))
                .build()
                .execute(new MyStringCallback());
    }


    public class MyStringCallback extends StringCallback {
        @Override
        public void onBefore(okhttp3.Request request) {
            super.onBefore(request);
            setTitle("loading...");
        }

        @Override
        public void onAfter() {
            super.onAfter();
            setTitle("Sample-okHttp");
        }

        @Override
        public void onError(okhttp3.Call call, Exception e) {
            e.printStackTrace();
            text.setText("失败+onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response) {
            Log.e("TAG","onResponse：complete");
            text.setText("响应+onResponse:" + response);
        }

        @Override
        public void inProgress(float progress) {
            Log.e(TAG, "inProgress:" + progress);
//            text.setProgress((int) (100 * progress));
        }
    }
    private void post() {
//        String url = NetWork.HTTP_ROOT + NetWork.PHONE_LOGIN;
         String url = "http://www.baidu.com/";
                   /*创建okHttpClient对象*/
        OkHttpClient mOC = new OkHttpClient();
                /*创建一个Request*/
        final Request request = new Request.Builder()
                .url(url)
                .build();
                /*new call*/
        Call call = mOC.newCall(request);//类似于将请求封装成任务
                /*请求加入调度*/
        call.enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String res = response.body().string();//返回的是字符串（当为.bytes()返回的是二进制节数组 当为.byteStream()返回的是inputStream）
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(res);
                    }
                });
            }
        });
    }

    private void postContent() {
//        String url = NetWork.HTTP_ROOT + NetWork.PHONE_LOGIN;
        String url = "http://www.baidu.com/";

        OkHttpClient mOC = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        String username = he1.getText().toString();
        String password = he2.getText().toString();
        builder.add("username", username);
        builder.add("password", password);
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        mOC.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String res = response.body().toString();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(res);
                        Log.i(TAG, "run: " + res);
                    }
                });
            }
        });

    }

    public void getUser() {
        mModel = (List<UserInfo>) new UserInfo();
        String username = he1.getText().toString();
        String password = he2.getText().toString();
//        String url = NetWork.HTTP_ROOT + NetWork.PHONE_LOGIN;
        String url = "http://www.baidu.com/";
//        ContentValues vs = new ContentValues();
//        vs.put("B_username",username);
//        vs.put("B_password",password);

        Map<String, String> parms = new HashMap<>();
        parms.put(username, password);

        OkHttpUtils
                .post()
                .url(url)
                .params(parms)
                .build()
                .execute(new UserCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e) {
                        text.setText("错误" + e.getMessage());
                        Log.i(TAG, "错误: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(User response) {
                        final String res = response.username;
                        text.setText("响应" + response.username);
                        Log.i(TAG, "响应: " + response.username);
                    }
                });
    }
}
