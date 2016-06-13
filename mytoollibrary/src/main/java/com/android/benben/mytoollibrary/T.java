package com.android.benben.mytoollibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by benben on 2016/6/13.
 * Toast统一管理类
 */
public class T {
    public T() {
        /*不能被实例化*/
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /*短时间显示Toast*/
    public static void showShort(Context context, CharSequence message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /*短时间显示Toast*/
    public static void showShort(Context context, int message) {
        if (isShow)
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    /*短时间显示Toast*/
    public static void showLong(Context context, CharSequence message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /*短时间显示Toast*/
    public static void showLonf(Context context, int message) {
        if (isShow)
            Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(context,message,duration).show();
    }

    public static void show(Context context, int message, int duration) {
        if (isShow)
            Toast.makeText(context,message,duration).show();
    }
}
