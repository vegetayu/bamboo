package com.yuluyao.logger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import yuluyao.logger.Logger

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    tvHello?.setOnClickListener {
      Logger.v("点击了这里")
      Logger.v("tag", "点击了这里")

      val tag: String? = "tag-string-no-null"
      Logger.v(tag, "点击了这里")

      val tag2: String? = null
      Logger.v(tag2, "点击了这里")

      Logger.v(this@MainActivity, "点击了这里")
      Logger.v(this, "点击了这里")
    }
  }
}