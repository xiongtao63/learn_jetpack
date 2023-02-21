package com.xiongtao.dagger2.use3.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.xiongtao.dagger2.R;
import com.xiongtao.dagger2.use3.app.MyApplication;
import com.xiongtao.dagger2.use3.component.DaggerMyComponent;
import com.xiongtao.dagger2.use3.obj.HttpObject;

import javax.inject.Inject;

public class MainActivity1 extends AppCompatActivity {
    @Inject
    HttpObject httpObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        DaggerMyComponent.create().inject(this);
        ((MyApplication)getApplication()).getAppComponent().inject(this);
        Log.i("derry", httpObject.hashCode() + " MainActivity2");
    }
}