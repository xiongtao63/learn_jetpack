package com.xiongtao.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.xiongtao.jetpack.R

class DataBindingActivity : AppCompatActivity() {
     lateinit var user:User
    lateinit var funs:Funs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = User("zhangsan","232432")
        funs = Funs("景甜","111")
        var binding: CustomBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        binding.userInfo = user

        binding.funs = funs
        binding.action = ButtonAction()

    }



    inner class ButtonAction{
        fun addFuns() {
            Log.i("======","${funs.number}")
            val n = funs.number.toInt() + 1
            Log.i("======","${funs.number.toInt()+1}")
            funs.number = n.toString()
            funs.name = "dsfdsfd"
            Log.i("======","${funs.number}")
        }
    }
}