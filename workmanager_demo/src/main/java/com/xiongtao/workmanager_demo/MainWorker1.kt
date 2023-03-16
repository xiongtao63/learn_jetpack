package com.xiongtao.workmanager_demo

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-15 14:04
 */
class MainWorker1(context: Context,workerParameters: WorkerParameters): Worker(context,workerParameters) {
    companion object { const val TAG = "Derry" }
    override fun doWork(): Result {
        Log.d(TAG, "MainWorker1 doWork: run started ... ")
        try {
            Thread.sleep(8000) // 睡眠
        } catch (e: InterruptedException) {
            e.printStackTrace()
            Result.failure(); // 本次任务失败
        } finally {
            Log.d(TAG, "MainWorker1 doWork: run end ... ")
        }
        return Result.success()
    }

}