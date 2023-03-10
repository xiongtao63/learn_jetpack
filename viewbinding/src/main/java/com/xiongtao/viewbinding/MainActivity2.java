package com.xiongtao.viewbinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xiongtao.viewbinding.databinding.ActivityMain2Binding;

// ViewBinding背后不是用 APT 注解处理器 使用什么？  答：gradle插件
public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding main2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView(R.layout.activity_main2);

        // 以前的用法  面向过程开发
        /*TextView textView1 = findViewById(R.id.tv1);
        TextView textView2 = findViewById(R.id.tv2);
        TextView textView3 = findViewById(R.id.tv2);*/

        // XUtils ... 也能解决此问题

        // TestBinding

        main2Binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(main2Binding.getRoot());

        main2Binding.tv1.setText("AAA");
        main2Binding.tv2.setText("BNB");
        main2Binding.tv3.setText("DDDD");
    }
}
