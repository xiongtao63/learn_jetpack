package com.xiongtao.dagger2.use1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xiongtao.dagger2.R;
import com.xiongtao.dagger2.use1.component.DaggerMyComponent;
import com.xiongtao.dagger2.use1.module.HttpModule;
import com.xiongtao.dagger2.use1.obj.DatabaseObject;
import com.xiongtao.dagger2.use1.obj.HttpObject;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    HttpObject httpObject;
    @Inject
    HttpObject httpObject1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DaggerMyComponent.builder().httpModule(new HttpModule())
                .build().inject(this);

        // 不一样的hashCode  答：非单例
        Log.i("derry", httpObject.hashCode() + " MainActivity"); // 不一样的hashCode
        Log.i("derry", httpObject1.hashCode() + " MainActivity");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity1.class));
            }
        });
    }
}