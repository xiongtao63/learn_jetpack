package com.xiongtao.jetpack.databinding.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.xiongtao.jetpack.R;
import com.xiongtao.jetpack.databinding.ActivityDataBinding1Binding;

public class DataBindingActivity1 extends AppCompatActivity {

    private Star star;
    private Star2 star2;
    private ObservableArrayMap<String, Object> observalbeArrayMap;
    private Star3 star3;
    private Star4ViewModel star4VM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding1);
        ActivityDataBinding1Binding binding1Binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding1);
        star = new Star();
        star.setName("dsfds");
        star.setFans(100);
        binding1Binding.setStar(star);
        star2 = new Star2(new ObservableField<String>("张三"),new ObservableField<Integer>(1011));
        binding1Binding.setStar2(star2);
        binding1Binding.setAction(new ButtonAction());

        observalbeArrayMap = new ObservableArrayMap<String,Object>();
        observalbeArrayMap.put("name","dsfdsfdsf");
        observalbeArrayMap.put("fans",1231);
        binding1Binding.setArrayMap(observalbeArrayMap);

        star3 = new Star3();
        star3.setName(new ObservableField<String>("dd"));
        binding1Binding.setStar3(star3);

        star4VM = new Star4ViewModel();
        star4VM.mutableLiveData.setValue(new Star4("dsfds",20302));
        binding1Binding.setStar4(star4VM);
        star4VM.mutableLiveData.observe(this, new Observer<Star4>() {
            @Override
            public void onChanged(Star4 star4) {
                binding1Binding.setStar4(star4VM);
            }
        });

    }


    public class ButtonAction{
        public void addFans(){
            int n = star.getFans() +10;
            star.setName("dddddddd");
            star.setFans(n);
        }
        public void addFans2(){
            int n = star2.getFans().get() +101;
            star2.getFans().set(n);

        }
        public void addFans3(){
//            int n = star2.getFans().get() +101;
            int fans = Integer.valueOf(String.valueOf(observalbeArrayMap.get("fans"))) + 100;
            observalbeArrayMap.put("fans",fans);

        }
    }
}