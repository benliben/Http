package com.android.benben.http.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by LiYuanxiong on 2016/6/17 10:18.
 * Desribe:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResultBean extends BaseBean{

    String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

