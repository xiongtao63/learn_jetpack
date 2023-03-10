package com.xiongtao.livedata_demo.simple4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.xiongtao.livedata_demo.R

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-07 15:47
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // 如果LiveData默认的黏性，会产生Bug，你就需要剔除黏性

        // livedata发消息通知所有的观察者数据变化了
        OKLiveDataBusKT.with("data1",String::class.java,false).value = "sdfasdfa"
        OKLiveDataBusJava.getInstance().with("data2", String::class.java).value= "Nine Suns" // Java版本
        // 点击事件，跳转下一个Activity
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}