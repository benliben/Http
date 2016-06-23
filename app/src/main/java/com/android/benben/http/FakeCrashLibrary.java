package com.android.benben.http;

import android.util.Log;

/**
 * Created by tangjunjie on 2016/6/17.
 */
public class FakeCrashLibrary {

    public static void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
        Log.d(tag, "xxxxxxxxxxxxxxxxxxxxxxxxxx"+message + ":" + priority);
    }

    public static void logWarning(Throwable t) {
        // TODO report non-fatal warning.
    }

    public static void logError(Throwable t) {
        // TODO report non-fatal error.
    }

    private FakeCrashLibrary() {
        throw new AssertionError("No instances.");
    }

}
