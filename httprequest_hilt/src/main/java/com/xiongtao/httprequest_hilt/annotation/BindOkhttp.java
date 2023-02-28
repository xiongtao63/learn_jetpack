package com.xiongtao.httprequest_hilt.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-27 17:03
 */
@Qualifier// 此注解就是为了让 hilt 区分这个注解（做自己的逻辑处理）  自己定义标识，限定符号
@Retention(RetentionPolicy.RUNTIME)
public @interface BindOkhttp { // 业主三 的标记
}
