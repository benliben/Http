package com.android.benben.mytoollibrary;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by benben on 2016/6/13.
 * SD卡相关辅助类
 */
public class SDCardUtils {
    public SDCardUtils() {
        /*不能被实例化*/
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /*判断SDCard是否可用*/
    public static boolean isSDCardEnable() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**获取SD卡的路径*/
    public static String getSDCatdPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator;
    }

    /**
     * 获取SD卡的剩余容量 单位Byte
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getSDCardAllSize() {
        if (isSDCardEnable()) {
            StatFs stat = new StatFs(getSDCatdPath());//得到路径
            long availableBlocks = stat.getAvailableBlocksLong() - 4;//得到空闲数据块的数量
            long freeBlocks = stat.getAvailableBlocksLong();//获取单个数量快的大小（byte）
            return freeBlocks * availableBlocks;
        }
        return 0;
    }


    /**
     * 获取指定路径所有空间的剩余可用容量字节数 单位byte
     * @param filePath
     * @return 容量字节 SDCard可用空间，内部存储可用空间
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getFreeBytes(String filePath) {
        if (filePath.startsWith(getSDCatdPath())) {//如果是sd卡下的路径，则获取sd卡可用用容量
            filePath = getSDCatdPath();
        }else {
            //如果是内部存储的路径，则获取内存存储的可用容量
            filePath = Environment.getDataDirectory().getAbsolutePath();
        }
        StatFs stat = new StatFs(filePath);
        long availableBlocks = (long) stat.getAvailableBlocksLong() - 4;
        return stat.getBlockSizeLong() * availableBlocks;
    }


    /**获取系统存储路径*/
    public static String getRootDirectoryPath() {
        return Environment.getRootDirectory().getAbsolutePath();
    }

}
