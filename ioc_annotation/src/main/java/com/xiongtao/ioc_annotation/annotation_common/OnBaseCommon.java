package com.xiongtao.ioc_annotation.annotation_common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-28 17:14
 */
// 注解的注解 = 元注解
@Target(ElementType.ANNOTATION_TYPE)// 本身自己就是注解，还可以作用域在 注解之上
@Retention(RetentionPolicy.RUNTIME)
public @interface OnBaseCommon {
    // 这里必须是通用代码，不能是固定代码

    // 总结 事件 三要数
    // TODO 1 订阅方式     setOnClickListener setOnLongClickListener setOnDragListener
    String setCommonListener();

    // TODO 2 事件源对象   View.OnClickListener  View.OnLongClickListener  一般都是一个函数
    Class setCommonObjectListener();

    // TODO 3 事件执行方法 onClick onLongClick   最终的事件消费
    String callbackMethod();
}
