package com.xiongtao.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.xiongtao.jetpack.databinding.DataBindingActivity
import com.xiongtao.jetpack.databinding.java.DataBindingActivity1
import com.xiongtao.jetpack.lifecycle.LifeCycleActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goToActivity(R.id.bt_lifecycle,LifeCycleActivity::class.java);
        goToActivity(R.id.bt_databinding,DataBindingActivity::class.java);
        goToActivity(R.id.bt_databinding1, DataBindingActivity1::class.java);

    }

    private fun <T> goToActivity(resId:Int, clazz: Class<T>){
        findViewById<Button>(resId).setOnClickListener {
            val intent = Intent(applicationContext, clazz)
            startActivity(intent)
        }
    }
}