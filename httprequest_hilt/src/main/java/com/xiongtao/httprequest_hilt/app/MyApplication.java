package com.xiongtao.httprequest_hilt.app;

import android.app.Application;

import com.xiongtao.httprequest_hilt.annotation.BindOkhttp;
import com.xiongtao.httprequest_hilt.annotation.BindVolley;
import com.xiongtao.httprequest_hilt.annotation.BindXUtils;
import com.xiongtao.httprequest_hilt.network.http.IHttpRequest;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-27 17:03
 */
@HiltAndroidApp
public class MyApplication extends Application {

    @BindVolley // 例如：2016年 用这个库
//    @BindXUtils // 例如：2018年 用这个库
    // @BindOkhttp // 例如：2021年 用这个库
    @Inject
    IHttpRequest iHttpRequest; // @Inject hilt框架就已经帮你注入进来了


    // 例如：其他的 SDK版本  1.x  2.x  3.x  4.x 升级的改动，只需要动一行代码
    // 所以，同学们要活学活用哦

    // 暴露给Activity用，说白了，就是暴露给 客户
    public IHttpRequest getHttpRequest() {
        return iHttpRequest;
    }
}
