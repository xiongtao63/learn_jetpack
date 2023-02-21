package com.xiongtao.dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerStudentComponent.create().injectActivity(this);
        Toast.makeText(this, "student:" + student.hashCode(), Toast.LENGTH_SHORT).show();
    }
}