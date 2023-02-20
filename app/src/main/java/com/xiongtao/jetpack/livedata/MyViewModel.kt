package com.xiongtao.jetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023/2/7 15:46
 */
class MyViewModel: ViewModel() {
    val currentSecond:MutableLiveData<Int> by lazy {
        val mutableLiveData = MutableLiveData<Int>()
        mutableLiveData.value = 0
        mutableLiveData
    }
}