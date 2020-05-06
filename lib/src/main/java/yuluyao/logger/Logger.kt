package yuluyao.logger

import android.util.Log

/**
 * Created by hhly-pc on 2016/12/23.
 */
object Logger {

  //<editor-fold desc="config">
  private const val DEFAULT_TAG = "vegeta"

  var defaultTag = DEFAULT_TAG
  var logEnable = true
  //</editor-fold>



  //<editor-fold desc="verbose">
  fun v(msg: String) {
    v(null, msg)
  }

  fun v(tag: Any?, msg: String?) = when (tag) {
    null -> printLog(VERBOSE, defaultTag, msg)
    is String -> printLog(VERBOSE, tag, msg)
    else -> printLog(VERBOSE, tag.javaClass.simpleName, msg)
  }
  //</editor-fold>

  //<editor-fold desc="debug">
  fun d(msg: String) {
    d(null, msg)
  }

  fun d(tag: Any?, msg: String?) = when (tag) {
    null -> printLog(DEBUG, defaultTag, msg)
    is String -> printLog(DEBUG, tag, msg)
    else -> printLog(DEBUG, tag.javaClass.simpleName, msg)
  }
  //</editor-fold>

  //<editor-fold desc="info">
  fun i(msg: String) {
    i(null, msg)
  }

  fun i(tag: Any?, msg: String?) = when (tag) {
    null -> printLog(INFO, defaultTag, msg)
    is String -> printLog(INFO, tag, msg)
    else -> printLog(INFO, tag.javaClass.simpleName, msg)
  }
  //</editor-fold>

  //<editor-fold desc="warn">
  fun w(msg: String) {
    w(null, msg)
  }

  fun w(tag: Any?, msg: String?) = when (tag) {
    null -> printLog(WARN, defaultTag, msg)
    is String -> printLog(WARN, tag, msg)
    else -> printLog(WARN, tag.javaClass.simpleName, msg)
  }
  //</editor-fold>

  //<editor-fold desc="error">
  fun e(msg: String) {
    e(null, msg)
  }

  fun e(tag: Any?, msg: String?) = when (tag) {
    null -> printLog(ERROR, defaultTag, msg)
    is String -> printLog(ERROR, tag, msg)
    else -> printLog(ERROR, tag.javaClass.simpleName, msg)
  }
  //</editor-fold>

  //<editor-fold desc="internal">

  private const val VERBOSE = "v"
  private const val DEBUG = "d"
  private const val INFO = "i"
  private const val WARN = "w"
  private const val ERROR = "e"

  private fun printLog(level: String, tag: String, msg: String?) {
    if (!logEnable) {
      return
    }
    val clickableMessage = buildClickableMessage(level, msg)
    when (level) {
      VERBOSE -> Log.v(tag, clickableMessage)
      DEBUG -> Log.d(tag, clickableMessage)
      INFO -> Log.i(tag, clickableMessage)
      WARN -> Log.w(tag, clickableMessage)
      ERROR -> Log.e(tag, clickableMessage)
    }
  }

  private fun buildClickableMessage(level: String, msg: String?): String {
    val stackTraceElement = Thread.currentThread().stackTrace
    var currentIndex = -1
    for (i in stackTraceElement.indices) {
      if (stackTraceElement[i].methodName.compareTo(level) == 0) {
        currentIndex = i
      }
    }
    currentIndex++
    val fullClassName = stackTraceElement[currentIndex].className
    val className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1)
    val methodName = stackTraceElement[currentIndex].methodName
    val lineNumber = stackTraceElement[currentIndex].lineNumber.toString()
    return """
      $msg
      at $fullClassName.$methodName($className.java:$lineNumber)
      """.trimIndent()
  }
  //</editor-fold>


}