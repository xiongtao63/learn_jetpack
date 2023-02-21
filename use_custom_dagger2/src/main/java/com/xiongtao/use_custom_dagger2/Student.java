package com.xiongtao.use_custom_dagger2;

import com.xiongtao.custom_dagger2.annotation.Inject;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 17:07
 */
// 第一个注解
// 电脑
public class Student {

    @Inject // 标记 代表此对象Student 是被注入的来源Student   ---> MainActivity目标
    public Student() {

    }

}
