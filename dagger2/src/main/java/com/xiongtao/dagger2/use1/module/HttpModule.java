package com.xiongtao.dagger2.use1.module;

import com.xiongtao.dagger2.use1.obj.HttpObject;

import dagger.Module;
import dagger.Provides;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 14:25
 */
@Module
public class HttpModule {

    @Provides
    public HttpObject providerHttpObject(){
        return new HttpObject();
    }
}
