package com.xiongtao.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiongtao.viewbinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tv1
import kotlinx.android.synthetic.main.activity_main.tv2
import kotlinx.android.synthetic.main.activity_main.tv3
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 绑定机制的缺点
//        setContentView(R.layout.activity_main)
//        tv1.text = "AAA"
//        tv2.text = "BBB"
//        tv3.text = "CCC"
//        tv1.text = "ddd"
        val vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
        vb.tv1.text = "aaa"
        vb.tv2.text = "bbb"
        vb.tv3.text = "ccc"
    }
}