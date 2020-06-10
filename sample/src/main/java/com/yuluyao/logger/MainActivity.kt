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
      Logger.v("my message")
      Logger.v("tag", "my message")

      val tag: String? = "tag-string-no-null"
      Logger.v(tag, "my message")

      val tag2: String? = null
      Logger.v(tag2, "my message")

      Logger.v(this@MainActivity, "my message")
      Logger.v(this, "my message")
    }
  }
}