package com.xiongtao.httprequest_hilt.network.module;

import com.xiongtao.httprequest_hilt.annotation.BindOkhttp;
import com.xiongtao.httprequest_hilt.annotation.BindVolley;
import com.xiongtao.httprequest_hilt.annotation.BindXUtils;
import com.xiongtao.httprequest_hilt.network.OkHttpRequest;
import com.xiongtao.httprequest_hilt.network.VolleyRequest;
import com.xiongtao.httprequest_hilt.network.XUtilsRequest;
import com.xiongtao.httprequest_hilt.network.http.IHttpRequest;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-27 17:14
 */

// 以前的业务员，现在的 包裹对象
@Module
@InstallIn(ApplicationComponent.class) // 就是为了 业主的单例  注入到MyApplication
public abstract class HttpRequestModule {
    //  @Binds      接口                实现类      绑定关系
    @BindOkhttp
    @Binds
    @Singleton // 全局单例 必须用 @InstallIn(ApplicationComponent.class)
    abstract IHttpRequest bindOkhttp(OkHttpRequest okHttpRequest);

    //  @Binds      接口                实现类      绑定关系
    @BindVolley
    @Binds
    @Singleton // 全局单例 必须用 @InstallIn(ApplicationComponent.class)
    abstract IHttpRequest bindVolley(VolleyRequest volleyRequest);

    //  @Binds      接口                实现类      绑定关系
    @BindXUtils
    @Binds
    @Singleton // 全局单例 必须用 @InstallIn(ApplicationComponent.class)
    abstract IHttpRequest bindXUtils(XUtilsRequest xUtilsRequest);
}
