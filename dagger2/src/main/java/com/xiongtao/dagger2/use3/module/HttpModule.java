package com.xiongtao.dagger2.use3.module;


import com.xiongtao.dagger2.use3.obj.HttpObject;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 14:25
 */

@Module
public class HttpModule {

    @Singleton
    @Provides
    public HttpObject providerHttpObject(){
        return new HttpObject();
    }
}
