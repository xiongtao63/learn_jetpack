package com.xiongtao.databinding_demo.model

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-09 15:48
 */
class StudentInfo : BaseObservable() {
    var name:String? = null
//    @Bindable  //解决办法  apply plugin: 'kotlin-kapt'
    get() {
        return field
    }
    set(value) {
        field = value
//        notifyPropertyChanged(BR.name)
    }

    var pwd : String? = null


    // 第二种方式  已修复  懒加载
    val nameF : ObservableField<String> by lazy { ObservableField<String>() }
    val pwdF : ObservableField<String> by lazy { ObservableField<String>() }
}