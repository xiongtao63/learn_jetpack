package com.xiongtao.room_demo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.xiongtao.room_demo.dao.StudentDao;
import com.xiongtao.room_demo.entity.Student;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-10 16:26
 */
@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;

    public static synchronized AppDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context,AppDataBase.class,"my.db")

                    // 可以强制在主线程运行数据库操作
                    .allowMainThreadQueries()

                    // 暴力升级 不管三七二十一 强制执行（数据会丢失）(慎用)
                    // .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    public abstract StudentDao userDao();
}
