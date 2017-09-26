package capsule.bamboo;

import android.util.Log;

/**
 * Created by hhly-pc on 2016/12/23.
 */

public class Logger {

  private static final String DEFAULT_TAG = "vegeta";

  private static String  tag       = DEFAULT_TAG;
  private static boolean logEnable = true;

  public static void configTag(String tag) {
    Logger.tag = tag;
  }

  public static void configLogEnable(boolean logEnable) {
    Logger.logEnable = logEnable;
  }

  /* ******* verbose ****** */

  public static void v(String msg) {
    v(null, msg);
  }

  public static void v(Object clazz, String msg) {
    Class c = clazz.getClass();
    String className = c.getName();
    className = className.substring(className.lastIndexOf("."));
    v(className, msg);
  }

  public static void v(String tag, String msg) {
    String t = buildTag(tag);
    String message = buildMsg(msg);
    printLog("v", t, message);
  }
  /* ******* debug ****** */

  public static void d(String msg) {
    d(null, msg);
  }

  public static void d(Object clazz, String msg) {
    Class c = clazz.getClass();
    String className = c.getName();
    className = className.substring(className.lastIndexOf("."));
    d(className, msg);
  }

  public static void d(String tag, String msg) {
    String t = buildTag(tag);
    String message = buildMsg(msg);
    printLog("d", t, message);
  }
  /* ******* information ****** */

  public static void i(String msg) {
    i(null, msg);
  }

  public static void i(Object clazz, String msg) {
    Class c = clazz.getClass();
    String className = c.getName();
    className = className.substring(className.lastIndexOf("."));
    i(className, msg);
  }

  public static void i(String tag, String msg) {
    String t = buildTag(tag);
    String message = buildMsg(msg);
    printLog("i", t, message);
  }
  /* ******* warning ****** */

  public static void w(String msg) {
    w(null, msg);
  }

  public static void w(Object clazz, String msg) {
    Class c = clazz.getClass();
    String className = c.getName();
    className = className.substring(className.lastIndexOf("."));
    w(className, msg);
  }

  public static void w(String tag, String msg) {
    String t = buildTag(tag);
    String message = buildMsg(msg);
    printLog("w", t, message);
  }
  /* ******* error ****** */

  public static void e(String msg) {
    e(null, msg);
  }

  public static void e(Object clazz, String msg) {
    Class c = clazz.getClass();
    String className = c.getName();
    className = className.substring(className.lastIndexOf("."));
    e(className, msg);
  }

  public static void e(String tag, String msg) {
    String t = buildTag(tag);
    String message = buildMsg(msg);
    printLog("e", t, message);
  }

  /* ****** internal method ****** */

  private static String buildTag(String tag) {
    return tag == null ? Logger.tag : tag;
  }

  private static String buildMsg(String msg) {
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

    return msg
        + "\nat "
        + fullClassName
        + "."
        + methodName
        + "("
        + className
        + ".java:"
        + lineNumber
        + ")";
  }

  private static void printLog(String level, String tag, String msg) {
    if (!logEnable) {
      return;
    }
    switch (level) {
      case "v":
        Log.v(tag, msg);
        break;
      case "d":
        Log.d(tag, msg);
        break;
      case "i":
        Log.i(tag, msg);
        break;
      case "w":
        Log.w(tag, msg);
        break;
      case "e":
        Log.e(tag, msg);
        break;
    }
  }
}
