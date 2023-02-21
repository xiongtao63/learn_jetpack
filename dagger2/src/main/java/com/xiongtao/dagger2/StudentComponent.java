package com.xiongtao.dagger2;

import dagger.Component;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 11:33
 */
@Component(modules = StudentModule.class)
public interface StudentComponent {
    void injectActivity(MainActivity mainActivity);
}
