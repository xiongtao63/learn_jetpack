package com.xiongtao.hileusesimple.simple3.interfacedi;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-23 17:10
 */
@Module
@InstallIn(ActivityComponent.class)// 注入到 Activity
public abstract class TestInterfaceModule {

    @Binds//        接口              与         实现类   的注入工作
    abstract TestInterface bindTestClass(TestClassImpl testClass);

}
