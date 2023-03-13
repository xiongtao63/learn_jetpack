package com.xiongtao.room_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.xiongtao.room_demo.dao.StudentDao;
import com.xiongtao.room_demo.db.AppDataBase;
import com.xiongtao.room_demo.entity.Student;
import com.xiongtao.room_demo.entity.StudentTuple;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 数据库的操作应该是在子线程
        DbTest t = new DbTest();
        t.start();
    }

    class DbTest extends Thread{
        @Override
        public void run() {
            AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "my.db")
//                    .allowMainThreadQueries()
                    .build();
            StudentDao dao = db.userDao();
            dao.insert(new Student("Derry0", "123", 1));
            dao.insert(new Student("Derry1", "456", 2));
            dao.insert(new Student("Derry2", "789", 3));
            dao.insert(new Student("Derry3", "111", 4));

            // 查询全部数据
            List<Student> all = dao.getAll();
            Log.d("Derry", "run: all.toString():" + all.toString());

            Log.i("Derry", "--------------------------");

            // 查询名字为 Derry3 的一条数据
            Student Derry3 = dao.findByName("Derry3");
            Log.d("Derry", "run: Derry3.toString():" + Derry3.toString());

            Log.i("Derry", "--------------------------");

            // 查询 2 3 4 uid的三条数据
            List<Student> allID = dao.getAllId(new int[]{2, 3, 4});
            Log.d("Derry", "run: allID.toString():" + allID.toString());

            Log.i("Derry", "--------------------------");

            // 查询student表里面的数据  到  StudentTuple里面去
            StudentTuple record = dao.getRecord();
            Log.d("Derry", "run: record.toString():" + record.toString());
        }
    }
}