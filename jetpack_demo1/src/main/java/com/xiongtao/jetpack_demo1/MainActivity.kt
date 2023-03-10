package com.xiongtao.jetpack_demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.xiongtao.jetpack_demo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

//        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(MainViewModel::class.java)

        binding?.vm = viewModel

        binding?.lifecycleOwner = this
    }
}