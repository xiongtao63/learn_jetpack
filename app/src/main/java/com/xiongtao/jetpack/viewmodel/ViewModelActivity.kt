package com.xiongtao.jetpack.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.xiongtao.jetpack.R

class ViewModelActivity : AppCompatActivity() {

    lateinit var myViewModel:MyViewModel
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        textView= findViewById<TextView>(R.id.textView)
        myViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(MyViewModel::class.java)
        textView.text = myViewModel.number.toString()
    }

    fun plusnumber(view: android.view.View) {
       textView.text = myViewModel.number++.toString()
    }
}