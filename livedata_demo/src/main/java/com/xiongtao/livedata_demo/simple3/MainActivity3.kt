package com.xiongtao.livedata_demo.simple3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.xiongtao.livedata_demo.R

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // version++  == 0   第一步
            MyLiveData.value1.value = "我就是我，不一样的烟火1" // 以前的旧数据
            MyLiveData.value1.value = "我就是我，不一样的烟火2" // 以前的旧数据
            MyLiveData.value1.value = "我就是我，不一样的烟火3" // 以前的旧数据
            MyLiveData.value1.value = "我就是我，不一样的烟火4" // 以前的旧数据
            MyLiveData.value1.value = "我就是我，不一样的烟火5" // 以前的旧数据

            startActivity(Intent(this, MainActivity4::class.java))
        }
    }
}