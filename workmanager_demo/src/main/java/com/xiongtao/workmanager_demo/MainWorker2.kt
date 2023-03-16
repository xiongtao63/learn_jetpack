package com.xiongtao.workmanager_demo

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-15 14:04
 */
class MainWorker2(context: Context, val workerParameters: WorkerParameters): Worker(context,workerParameters) {
    companion object { const val TAG = "Derry" }

    // 后台任务 并且 异步的 （原理：线程池执行Runnable）
    override fun doWork(): Result {
        Log.d(MainWorker2.TAG, "MainWorker2 doWork: 后台任务执行了")

        // 接收 MainActivity传递过来的数据
        val dataString = workerParameters.inputData.getString("Derry")
        Log.d(MainWorker2.TAG, "MainWorker2 doWork: 接收MainActivity传递过来的数据:$dataString")
        // 正在执行中 RUNNING

        // 反馈数据 给 MainActivity
        // 把任务中的数据回传到MainActivity中
        val outputData = Data.Builder().putString("Derry", "sfsdfs").build()
        // return new Result.Failure(); // 本地执行 doWork 任务时 失败
        // return new Result.Retry(); // 本地执行 doWork 任务时 重试一次
        // return new Result.Success(); // 本地执行 doWork 任务时 成功 执行任务完毕
        return Result.success(outputData)
    }

}