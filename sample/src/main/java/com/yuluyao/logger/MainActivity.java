package com.yuluyao.logger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import yuluyao.logger.Logger;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView tvHello = (TextView) findViewById(R.id.tvHello);
    tvHello.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Logger.i("点击了这里");
      }
    });
    Logger.v("hello world!");
    Logger.d("hello world!");
    Logger.i("hello world!");
    Logger.w("hello world!");
    Logger.e("hello world!");
  }
}
