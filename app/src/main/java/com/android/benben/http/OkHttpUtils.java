package com.android.benben.http;

import com.example.benben.okhttputils.builder.PostFormBuilder;
import com.example.benben.okhttputils.builder.PostStringBuilder;

/**
 * Created by benben on 2016/6/13.
 */
public class OkHttpUtils {

    public static PostFormBuilder post() {
        return new PostFormBuilder();
    }
    public static PostStringBuilder postString() {
        return new PostStringBuilder();
    }
}
