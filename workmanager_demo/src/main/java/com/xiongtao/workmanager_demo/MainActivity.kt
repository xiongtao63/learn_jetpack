package com.xiongtao.workmanager_demo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() ,SharedPreferences.OnSharedPreferenceChangeListener{

    private var bt6 : Button ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt6 = findViewById< Button>(R.id.bt6)
        // 绑定 SP 变化监听
        val sp = getSharedPreferences(MainWorker7.SP_NAME, MODE_PRIVATE)
        sp.registerOnSharedPreferenceChangeListener(this)
        updateToUI() // 第一次初始一把
    }
    fun testBackgroundWork1(view: android.view.View) {
        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(MainWorker1::class.java).build()
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
    }
    fun testBackgroundWork2(view: android.view.View) {
        // 单一的任务  一次
        val oneTimeWorkRequest1: OneTimeWorkRequest
        val sendData = Data.Builder().putString("Derry","aaaaaaaaa").build()
        oneTimeWorkRequest1 = OneTimeWorkRequest.Builder(MainWorker2::class.java)
            .setInputData(sendData)
            .build()
// 一般都是通过 状态机 接收 WorkManager2的回馈数据
        // 状态机（LiveData） 才能接收 WorkManager回馈的数据
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest1.id)
            .observe(this,{ workInfo->

                // ENQUEUED,RUNNING,SUCCEEED
                Log.d(MainWorker2.TAG, "状态：" + workInfo.state.name)

                // ENQUEUED, RUNNING  都取不到 回馈的数据 都是 null
                // Log.d(MainWorker2.TAG, "取到了任务回传的数据: " + workInfo.outputData.getString("Derry"))
                if(workInfo.state.isFinished){
                    Log.d(MainWorker2.TAG, "取到了任务回传的数据: " + workInfo.outputData.getString("Derry"))
                }

        })

        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest1)
    }
    fun testBackgroundWork3(view: android.view.View) {
        // 单一的任务  一次
        val oneTimeWorkRequest3 = OneTimeWorkRequest.Builder(MainWorker3::class.java).build()
        val oneTimeWorkRequest4 = OneTimeWorkRequest.Builder(MainWorker4::class.java).build()
        val oneTimeWorkRequest5 = OneTimeWorkRequest.Builder(MainWorker5::class.java).build()
        val oneTimeWorkRequest6 = OneTimeWorkRequest.Builder(MainWorker6::class.java).build()

        WorkManager.getInstance(this)
            .beginWith(oneTimeWorkRequest3)
            .then(oneTimeWorkRequest4)
            .then(oneTimeWorkRequest5)
            .then(oneTimeWorkRequest6)
            .enqueue()

        // 需求：先执行  3  4    最后执行 6
        val oneTimeWorkRequests: MutableList<OneTimeWorkRequest> = ArrayList() // 集合方式
        oneTimeWorkRequests.add(oneTimeWorkRequest3) // 先同步日志信息
        oneTimeWorkRequests.add(oneTimeWorkRequest4) // 先更新服务器数据信息

        WorkManager.getInstance(this).beginWith(oneTimeWorkRequests)
            .then(oneTimeWorkRequest6) // 最后再 检查同步
            .enqueue()
    }
    fun testBackgroundWork4(view: android.view.View) {
        // OneTimeWorkRequest 单个  前面的三个例子  不会轮询 执行一次就OK

        // 重复的任务  多次/循环/轮询  , 哪怕设置为 10秒 轮询一次,   那么最少轮询/循环一次 15分钟（Google规定的）
        // 不能小于15分钟，否则默认修改成15分钟
        val periodicWorkRequest =
            PeriodicWorkRequest.Builder(MainWorker3::class.java, 10, TimeUnit.SECONDS).build()
        // 【状态机】  为什么一直都是 ENQUEUE，因为 你是轮询的任务，所以你看不到 SUCCESS        [如果你是单个任务，就会看到SUCCESS结束任务]
        // 监听状态
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.id)
            .observe(this, { workInfo ->
                Log.d(MainWorker2.TAG, "状态：" + workInfo.state.name) // ENQUEEN   RUNN  循环反复
                if (workInfo.state.isFinished) {
                    Log.d(MainWorker2.TAG, "状态：isFinished=true 同学们注意：后台任务已经完成了...")
                }
            })
        WorkManager.getInstance(this).enqueue(periodicWorkRequest)

        // 取消 任务的执行
        // WorkManager.getInstance(this).cancelWorkById(periodicWorkRequest.getId());
    }
    fun testBackgroundWork5(view: android.view.View) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) // 必须是联网中
            /*.setRequiresCharging(true) // 必须是充电中
            .setRequiresDeviceIdle(true) // 必须是空闲时（例如：你没有玩游戏  例如：你有没有看大片 1亿像素的）*/
            .build()

        /**
         * 除了上面设置的约束外，WorkManger还提供了以下的约束作为Work执行的条件：
         * setRequiredNetworkType：网络连接设置
         * setRequiresBatteryNotLow：是否为低电量时运行 默认false
         * setRequiresCharging：是否要插入设备（接入电源），默认false
         * setRequiresDeviceIdle：设备是否为空闲，默认false
         * setRequiresStorageNotLow：设备可用存储是否不低于临界阈值
         */

        // 请求对象
        val request = OneTimeWorkRequest.Builder(MainWorker3::class.java)
            .setConstraints(constraints) // Request 关联  约束条件
            .build()

        // 加入队列
        WorkManager.getInstance(this).enqueue(request)

    }
    fun testBackgroundWork6(view: android.view.View) {
        // 约束条件
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) // 约束条件，必须是网络连接
            .build()

        // 构建Request
        val request = OneTimeWorkRequest.Builder(MainWorker7::class.java)
            .setConstraints(constraints)
            .build()

        // 加入队列
        WorkManager.getInstance(this).enqueue(request)
    }
    // 从SP里面获取值，显示到界面给用户看就行了
    private fun updateToUI() {
        val sp = getSharedPreferences(MainWorker7.SP_NAME, MODE_PRIVATE)
        val resultValue = sp.getInt(MainWorker7.SP_KEY, 0)
        bt6 ?.setText("测试后台任务六 -- $resultValue")
    }

    // SP归零
    fun spReset(view: View?) {
        val sp = getSharedPreferences(MainWorker7.SP_NAME, MODE_PRIVATE)
        sp.edit().putInt(MainWorker7.SP_KEY, 0).apply()
        updateToUI()
    }

    fun codeStudy(view: android.view.View) {}
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?)= updateToUI()

}