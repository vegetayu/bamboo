package com.capsule.util;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by hhly-pc on 2016/12/23.
 */

public class Logger {

    private static String tag = "vegeta";
    private static boolean logEnable = true;


    public static void setTag(String tag) {
        Logger.tag = tag;
    }

    public static void setLogEnable(boolean logEnable) {
        Logger.logEnable = logEnable;
    }

    public static void i(String msg) {
        i(null, msg);
    }

    public static void i(Object o, String msg) {
        Class c = o.getClass();
        String className = c.getName();
        className = className.substring(className.lastIndexOf("."));
        i(className, msg);
    }

    public static void i(String tag, String msg) {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        int currentIndex = -1;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getMethodName().compareTo("i") == 0) {
                currentIndex = i;
            }
        }
        currentIndex++;

        String fullClassName = stackTraceElement[currentIndex].getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        String methodName = stackTraceElement[currentIndex].getMethodName();
        String lineNumber = String.valueOf(stackTraceElement[currentIndex].getLineNumber());

        if (TextUtils.isEmpty(tag)) {
            Log.i(Logger.tag, msg + "\nat " + fullClassName + "." + methodName + "(" + className + ".java:" + lineNumber + ")");
        } else {
            Log.i(tag, msg + "\nat " + fullClassName + "." + methodName + "(" + className + ".java:" + lineNumber + ")");
        }

    }

}
