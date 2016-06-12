package com.android.benben.http;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.text)
    TextView text;
    private String TAG = "http";

    @InjectView(R.id.he_1)
    EditText he1;
    @InjectView(R.id.he_2)
    EditText he2;
    @InjectView(R.id.button1)
    Button button1;
    @InjectView(R.id.he_3)
    EditText he3;
    @InjectView(R.id.he_4)
    EditText he4;
    @InjectView(R.id.button2)
    Button button2;
    private String url = "http://www.baidu.com/";

    // 基本地址：服务器ip地址：端口号/Web项目逻辑地址+目标页面（Servlet）的url-pattern
    private String baseURL = "http://192.168.11.6:8080/HelloWeb/servlet/WelcomeUserServlet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                /*获取姓名和年龄*/
                String name = he1.getText().toString();
                String age = he2.getText().toString();

                /*使用get方法发送请求，需要吧参数加载url后面，用？链接，参数之间用&分隔开*/
//                String url = baseURL + "?username=" + name + "&age=" + age;

                /*创建okhttpclient对象*/
                OkHttpClient httpClient = new OkHttpClient();
                /*创建一个request*/
                final Request request = new Request.Builder()
                        .url("http://www.baibu.com/")
                        .build();
                /*New Call*/
                Call call = httpClient.newCall(request);
                /*请求加入调度*/
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {

                    }

                    @Override
                    public void onResponse(Response response) throws IOException {

                    }
                });
                break;
            case R.id.button2:
                String name1 = he3.getText().toString();
                String age2 = he4.getText().toString();
//                HttpUtils.doPostAsyn(url,name=name1,);
                break;
        }
    }
}
