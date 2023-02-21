package com.xiongtao.dagger2.use3.app;

import android.app.Application;

import com.xiongtao.dagger2.use3.component.DaggerMyComponent;
import com.xiongtao.dagger2.use3.component.MyComponent;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 16:30
 */
public class MyApplication extends Application {
    private MyComponent myComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        myComponent = DaggerMyComponent.builder().build();
    }

    public MyComponent getAppComponent(){
        return myComponent;
    }
}
