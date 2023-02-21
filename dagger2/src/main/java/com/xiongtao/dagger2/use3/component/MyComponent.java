package com.xiongtao.dagger2.use3.component;

import com.xiongtao.dagger2.use3.module.DatabaseModule;
import com.xiongtao.dagger2.use3.module.HttpModule;
import com.xiongtao.dagger2.use3.ui.MainActivity;
import com.xiongtao.dagger2.use3.ui.MainActivity1;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 15:41
 */
@Singleton
@Component(modules = {DatabaseModule.class, HttpModule.class})
public interface MyComponent {

    void inject(MainActivity mainActivity);
    void inject(MainActivity1 mainActivity1);
}
