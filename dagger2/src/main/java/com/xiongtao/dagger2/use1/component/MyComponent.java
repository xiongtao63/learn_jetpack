package com.xiongtao.dagger2.use1.component;

import com.xiongtao.dagger2.use1.module.DatabaseModule;
import com.xiongtao.dagger2.use1.module.HttpModule;
import com.xiongtao.dagger2.use1.ui.MainActivity;
import com.xiongtao.dagger2.use1.ui.MainActivity1;

import dagger.Component;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 15:41
 */
@Component(modules = {DatabaseModule.class, HttpModule.class})
public interface MyComponent {

    void inject(MainActivity mainActivity);
    void inject(MainActivity1 mainActivity1);
}
