package com.android.benben.mytoollibrary;

import android.util.Log;

/**
 * Created by benben on 2016/6/13.
 * 日志工具类L
 */
public class L {
    private L() {
        /*不能被实例化*/
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;//是否打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "way";

    /**下面是默认的Tag的函数*/
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    /**下面是传入自定义Tag的函数*/

    public static void i(String tag,String msg){
        if (isDebug)
            Log.i(tag, msg);
    }
    public static void d(String tag,String msg){
        if (isDebug)
            Log.i(tag, msg);
    }
    public static void e(String tag,String msg){
        if (isDebug)
            Log.i(tag,msg );
    }
    public static void v(String tag,String msg){
        if (isDebug)
            Log.i(tag, msg);
    }

}
