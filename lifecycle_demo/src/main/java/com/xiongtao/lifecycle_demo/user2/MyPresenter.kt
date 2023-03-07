package com.xiongtao.lifecycle_demo.user2

import android.util.Log

class MyPresenter {

    private val TAG = "MyPresenter"

    fun onResume() = Log.d(TAG, "onResume run ...")

    fun onPause() = Log.d(TAG, "onPause run ...")
}