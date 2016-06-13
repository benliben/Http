package com.android.benben.http;

/**
 * Created by benben on 2016/6/13.
 */
public class NetWork {
    public final static String IP_ADDRESS;
    public final static int WEB_PORT;
    public final static int SOCKET_PORT;
    static {
        IP_ADDRESS ="125.71.208.82";
        WEB_PORT = 8341;
        SOCKET_PORT = 2048;
    }

    public final static String HTTP_ROOT = "http://"+IP_ADDRESS+":"+WEB_PORT+"/erp/";
    public final static String PHONE_LOGIN = "phone_login";// 手机登陆
}
