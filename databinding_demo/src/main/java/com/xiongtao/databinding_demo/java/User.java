package com.xiongtao.databinding_demo.java;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.xiongtao.databinding_demo.BR;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-09 15:22
 */
public class User extends BaseObservable {
    private String name;
    private String psw;

    public User(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    @Bindable  // BR里面标记生成 name数值标记
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
        notifyPropertyChanged(BR.psw);
    }
}
