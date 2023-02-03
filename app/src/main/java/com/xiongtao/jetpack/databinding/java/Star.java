package com.xiongtao.jetpack.databinding.java;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.xiongtao.jetpack.BR;

public class Star extends BaseObservable {
    private String name;

    @Bindable
    private int fans;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
        notifyChange();
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
        notifyPropertyChanged(BR.fans);
    }
}
