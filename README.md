# Logger


[![Release](https://jitpack.io/v/yuluyao/logger.svg)](https://jitpack.io/#yuluyao/logger)

A wrapper of android.util.Log. Print clickable log info.


## install

```groovy
implementation 'com.github.yuluyao:logger:0.3.2'
```
 
## how to use

1. log with default tag

```kotlin
    Logger.v("your message")
```

output:
```
2000-01-01 10:57:23.889 9310-9310/com.yuluyao.logger V/vegeta: my message
        at com.yuluyao.logger.MainActivity$onCreate$1.onClick(MainActivity$onCreate$1.java:13)
```

2. log with `String` tag

```kotlin
    Logger.v("tag", "your message")
```

output:
```
2000-01-01 10:57:23.896 9310-9310/com.yuluyao.logger V/tag: my message
        at com.yuluyao.logger.MainActivity$onCreate$1.onClick(MainActivity$onCreate$1.java:14)
```

3. log with `Object` tag

```kotlin
    Logger.v(this, "your message")
```

output:
```
2000-01-01 10:57:23.901 9310-9310/com.yuluyao.logger V/MainActivity: my message
        at com.yuluyao.logger.MainActivity$onCreate$1.onClick(MainActivity$onCreate$1.java:22)
```