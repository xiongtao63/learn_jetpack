package com.xiongtao.jetpack.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.xiongtao.jetpack.R
import java.util.*

class LiveDataActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        textView = findViewById<TextView>(R.id.textView2)
        viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                MyViewModel::class.java
            )
        textView.text = viewModel.currentSecond.value.toString()

        viewModel.currentSecond.observe(this,
            { t -> textView.text = t.toString() })

        startTimer()
    }

    private fun startTimer() {

        Timer().schedule(object : TimerTask() {
            override fun run() {
                val i = viewModel.currentSecond.value?.plus(1)
                Log.e("=======", i.toString())
                viewModel.currentSecond.postValue(i)
            }

        },1000,1000)
    }
}