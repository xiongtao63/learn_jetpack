package com.xiongtao.hileusesimple.simple3.interfacedi;

import android.util.Log;

import javax.inject.Inject;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-23 17:09
 */
public class TestClassImpl implements TestInterface{

    @Inject
    TestClassImpl(){}

    @Override
    public void method() {
        Log.i("derry", "恭喜恭喜你，注入成功√");
    }
}
