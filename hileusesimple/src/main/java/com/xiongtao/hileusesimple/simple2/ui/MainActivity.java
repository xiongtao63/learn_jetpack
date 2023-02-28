package com.xiongtao.hileusesimple.simple2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xiongtao.hileusesimple.R;
import com.xiongtao.hileusesimple.simple2.obj.HttpObject;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint  // 我是被注解的 被注入的
public class MainActivity extends AppCompatActivity {
    @Inject
    HttpObject httpObject;
    @Inject
    HttpObject httpObject2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 为什么能够控制  字节码插庄
        // DaggerCOm。create.inject(this);

        Log.i("derry", httpObject.hashCode() + "");
        Log.i("derry", httpObject2.hashCode() + "");
        Toast.makeText(this, httpObject.hashCode() + "", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, httpObject2.hashCode() + "", Toast.LENGTH_SHORT).show();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity1.class));
            }
        });
    }
}