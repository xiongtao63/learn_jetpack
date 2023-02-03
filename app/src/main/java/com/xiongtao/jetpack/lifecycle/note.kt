package com.xiongtao.jetpack.lifecycle

//Lifecycle是具有生命周期感知的组件
/**
 * LifecycleOwner
 *      获取生命周期状态的接口，实现就可以获取生命周期
 *
 * Lifecycle
 *      抽象类，定义生命周期状态枚举，ON_START...
 *      分发状态的枚举
 *
 *
 * LifecycleRegistry
 *      Lifecycle的唯一实现类
 *      注册Observer
 *      分发生命周期状态给Observer
 *
 *      关键方法
 *      addObserver()
 *      1，判断当前状态是否DESTROYED
 *      判断当前宿主（Activity/Fragment）的状态，如果是Destory则初始的状态就是Destory。其他的情况一律是Init
 *      2，将传入的Observer 封装成ObserverWithState
 *      3，判断statefulObserver是不是已经存在mObserverMap
 *      4，假如存在就直接return
 *      5，获取宿主的LifecycleOwner对象并且判断，为null 说明被destroy 直接返回
 *      6，判断是不是正在同步
 *      7，判断传入的Observer 状态
 *      8，如果宿主的状态和观察者Observer的状态 不一致，
 *      这里会将传入的Observer的状态和宿主状态作比较，
 *      假如不相同，传入的Observer的状态会不断升级，因为这个方法的状态一开始就是INITIALIZED，
 *      假如宿主到了onResume ，那传入的状态就会从INITIALIZED 到 onCreate 到 onResume。（这里是第一次同步状态，就是将Observer的状态和宿主的状态调成一致）
 *      upEvent方法升级
 *
 *      putIfAbsent
 *      操作单链表
 *      把新传入的状态赋值给mStart，然mEnd就会等于mStart。
 *      这里可以理解为：mStart为新的状态，mEnd为老的状态。
 *
 *      sync()
 *      同步状态并分发状态:
 *      observer.dispatchEvent(lifecycleOwner, event);
 *      最后调用
 *      mLifecycleObserver.onStateChanged(owner, event);分发状态
 *
 *      Activity 实现LifeCycle
 *      ComponentActivity，实现了LifecycleOwner
 *      ReportFragment.injectIfNeededIn(this);
 *      就是相当于Activity中初始化一个Fragment通过Fragment的生命周期去回调Activity的生命周期。
 *      最后也是moveToState 状态更新和分发
 *      当sdk>29时，Activity会注册一个回调
 *      LifecycleCallbacks 回调同步更新状态
 *
 *      Fragment如何实现Lifecycle
 *      LifecycleRegistry成员变量
 *      在每一个生命周期回调中都会调用HandleLifecycleEvent
 *      调用moveToState,最后sync()分发事件
 *
 *      总结
 *      一定要知道关键的三个类LifecycleOwner、Lifecycle、LifecycleRegistry这三个类在这个系统中具体的作用
 *      写一个基本的Lifecycle
 *      Activity29以上是通过回调来分发状态，29一下是通过ReportFragment来分发状态。
 *      Fragment的状态分发是直接通过生命周期的回调来分发。
 *      了解LifecycleRegistry的注册Observer方法，分发事件的方法。
 *
 *      参考
 *      https://www.jianshu.com/p/56dce8c05281
 *
 *
 * */