package com.xiongtao.hileusesimple.app;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-22 16:38
 */
// hilt 基本上都要 用 Application来辅助
@HiltAndroidApp
public class MyApplication extends Application {

}
