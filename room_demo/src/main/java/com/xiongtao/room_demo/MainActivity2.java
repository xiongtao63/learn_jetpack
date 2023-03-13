package com.xiongtao.room_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ListView;

import com.xiongtao.room_demo.entity.Student;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    StudentViewModel studentViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        studentViewModel.getAllLiveDataStudent().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                // 更新UI
                listView.setAdapter(new GoodsAdapter(MainActivity2.this, students));
            }
        });


        // 模拟 仓库
        new Thread()  {
            @Override
            public void run() {
                super.run();

                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 默认给数据库ROOM增加数据
                for (int i = 0; i < 50; i++) {
                    studentViewModel.insert(new Student("Derry", "123", 1));
                }
            }
        }.start();


        // 模拟仓库 数据库 数据被修改了，一旦数据库被修改，那么数据会驱动UI的发生改变
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    studentViewModel.update(new Student(6,"Derry" + i, "123", 1));
                }
            }
        }.start();

    }
}