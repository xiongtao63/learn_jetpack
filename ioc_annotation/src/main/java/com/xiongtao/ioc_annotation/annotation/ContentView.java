package com.xiongtao.ioc_annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-28 14:47
 */
@Target(ElementType.TYPE)// 注解作用域到 类上
@Retention(RetentionPolicy.RUNTIME)// 运行时期
public @interface ContentView {
    int value() default -1;// 你的布局 就是 int id值
}
