package com.xiongtao.hileusesimple.simple2.module;

import com.xiongtao.hileusesimple.simple2.obj.HttpObject;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.scopes.ActivityScoped;

// ActivityComponent.class    能注入到Activity，不能注入到Application
// ApplicationComponent.class 能注入到Activity， 能注入到Application
@InstallIn(ActivityComponent.class) // 注入到Activity里面去（按规则来，该是哪个注入，就写哪个，不要乱搞）
@Module
public class HttpModule {

    @Provides // 暴露对象 电脑
//    @Singleton  // 上面的InstallIn 必须是 (ApplicationComponent.class) 才能全局单例
    @ActivityScoped  // 上面的InstallIn 必须是 (ActivityComponent.class) 才能局部单例
    public HttpObject getHttpObject(){
        return new HttpObject();
    }
}
