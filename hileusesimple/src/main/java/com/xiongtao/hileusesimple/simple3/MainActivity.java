package com.xiongtao.hileusesimple.simple3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xiongtao.hileusesimple.R;
import com.xiongtao.hileusesimple.simple3.interfacedi.TestInterface;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint  // 我是被注解的 被注入的
public class MainActivity extends AppCompatActivity {
    @Inject
    TestInterface testInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 为什么能够控制  字节码插庄
        // DaggerCOm。create.inject(this);
        findViewById(R.id.button).setOnClickListener(v -> {
            testInterface.method();
        });
    }
}