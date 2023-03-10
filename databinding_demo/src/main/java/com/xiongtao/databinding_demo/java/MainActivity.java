package com.xiongtao.databinding_demo.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import com.xiongtao.databinding_demo.R;
import com.xiongtao.databinding_demo.databinding.ActivityMain2Binding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 模拟 Model数据是从 网络服务器来的
        User user;
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        ActivityMain2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);

        user = new User("Derry", "123");
        binding.setUser(user); // 必须要建立绑定关系，否则没有任何效果


        // Model（修改Model的数据）  ---> View（UI的控件就DataBinding自动刷新）  一向 更新
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        user.setName(user.getName() + "口"); // view.setText(text);
                        user.setPsw(user.getPsw() + "口");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        user.setName("888");
    }
}