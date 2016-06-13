package com.android.benben.mytoollibrary;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by benben on 2016/6/13.
 * 跟网络相关的工具类
 */
public class NetUtils {
    public NetUtils() {
        /*不能够被实例化*/
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    /**检查网络是否链接*/
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != cm) {
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**判断是否是WiFi链接*/
    public static boolean isWifi(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }else {
            return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
        }
    }


    /**打开网络设置界面*/
    public static void openSettirng(Activity activity) {
        Intent intent = new Intent("/");
        ComponentName cn = new ComponentName("com.android.settings",
                "com.android.settings.wirelessSettings");
        intent.setComponent(cn);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }
}
