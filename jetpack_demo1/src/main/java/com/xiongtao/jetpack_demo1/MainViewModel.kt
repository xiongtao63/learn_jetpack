package com.xiongtao.jetpack_demo1

import android.app.Application
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-10 10:34
 */
class MainViewModel(val context: Application) : AndroidViewModel(context) {

    val phone by lazy { MutableLiveData<String>() }

    init {
        phone.value = ""
    }

    fun appendNumber(number:String){
        phone.value = phone.value +number
    }

    fun backspaceNumber(){
        val length: Int = phone.value?.length ?: -1
        if(length > 0){
            phone.value = phone.value?.substring(0,phone.value!!.length-1)
        }
    }

    fun clear(){
        phone.value = ""
    }

    fun callPhone(){
        val intent = Intent()
        intent.action = Intent.ACTION_CALL
        intent.data = Uri.parse("tel:"+phone.value)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
}