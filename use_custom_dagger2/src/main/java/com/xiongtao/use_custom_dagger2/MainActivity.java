package com.xiongtao.use_custom_dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.xiongtao.custom_dagger2.annotation.Inject;
import com.xiongtao.use_custom_dagger2.apt_create_dagger2.DaggerStudentComponent;

public class MainActivity extends AppCompatActivity {
    @Inject // 第四个注解
    public Student student;

    @Inject // 第四个注解
    public Student student2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 第三个注解生成的类
        DaggerStudentComponent.create().inject(this);

        Toast.makeText(this, "student:" + student.hashCode(), Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "student:" + student2.hashCode(), Toast.LENGTH_SHORT).show();
    }
}