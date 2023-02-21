package com.xiongtao.custom_dagger2;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 16:56
 */
public interface Provider<T> {

    T get();
}
