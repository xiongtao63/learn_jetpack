package com.xiongtao.use_custom_dagger2;

import com.xiongtao.custom_dagger2.annotation.Component;

// 第三个注解
@Component(modules = StudentModule.class)
public interface StudentComponent { // 快递员

    // 写注入目标  MainActivity的this
    void inject(MainActivity mainActivity);
}
