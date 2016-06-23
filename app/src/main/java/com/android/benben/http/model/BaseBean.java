package com.android.benben.http.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by LiYuanxiong on 2016/6/17 10:20.
 * Desribe:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseBean {

private String resultCode;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
