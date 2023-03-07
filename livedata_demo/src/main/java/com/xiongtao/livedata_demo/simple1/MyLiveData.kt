package com.xiongtao.livedata_demo.simple1

import androidx.lifecycle.MutableLiveData

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-06 16:22
 */
object MyLiveData {  //单例
    //懒加载
    val info1:MutableLiveData<String> by lazy { MutableLiveData<String>() }
}