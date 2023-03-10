package com.xiongtao.livedata_demo.simple4

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.xiongtao.livedata_demo.R
import kotlin.concurrent.thread

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-07 15:49
 */
class MainActivity2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        OKLiveDataBusKT.with("data1",String::class.java).observe(this,{
            Toast.makeText(this, "Kotlin版本的 观察者:${it}", Toast.LENGTH_SHORT).show()
            Log.d("derry", "Kotlin版本的 观察者:${it}")
        })

        // Java版本订阅观察者(Java是模拟就剔除黏性的，你自己增加开关)
        OKLiveDataBusJava.getInstance().with("data2", String::class.java).observe(this, {
            Toast.makeText(this, "Java版本的 观察者:${it}", Toast.LENGTH_SHORT).show()
            Log.d("derry", "Java版本的 观察者:${it}")
        })

        thread {
            Thread.sleep(6000)
            OKLiveDataBusKT.with("data1", String::class.java).postValue("666")
        }

        thread {
            Thread.sleep(12000)
            OKLiveDataBusJava.getInstance().with("data2", String::class.java).postValue("121212")
        }
    }
}