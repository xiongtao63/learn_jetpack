package com.xiongtao.dagger2.use4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xiongtao.dagger2.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Dog dog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
