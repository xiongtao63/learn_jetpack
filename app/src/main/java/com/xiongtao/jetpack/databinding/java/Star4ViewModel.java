package com.xiongtao.jetpack.databinding.java;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Star4ViewModel extends ViewModel {
    MutableLiveData<Star4> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Star4> getMutableLiveData() {
        return mutableLiveData;
    }

//    public void setMutableLiveData(MutableLiveData<Star4> mutableLiveData) {
//        this.mutableLiveData = mutableLiveData;
//    }

    public void addFans(){
        System.out.println("==========");
        Star4 star4 = mutableLiveData.getValue();
        System.out.println("=========="+star4.getFans());
        int i = star4.getFans() + 1000;
        star4.setFans(i);
        System.out.println("=========="+star4.getFans());
        mutableLiveData.postValue(star4);
    }
}
