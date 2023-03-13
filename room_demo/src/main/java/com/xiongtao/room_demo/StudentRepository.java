package com.xiongtao.room_demo;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.xiongtao.room_demo.dao.StudentDao;
import com.xiongtao.room_demo.db.AppDataBase;
import com.xiongtao.room_demo.entity.Student;

import java.util.List;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-10 17:01
 */
public class StudentRepository {
    private LiveData<List<Student>> liveDataAllStudent;


    private StudentDao studentDao;

    public StudentRepository(Context context) {
        AppDataBase database = AppDataBase.getInstance(context);

        studentDao = database.userDao();
        if(liveDataAllStudent == null){
            liveDataAllStudent = studentDao.getAllLiveDataStudent();
        }

    }

    // 下面代码是：提供一些API给ViewModel使用

    // 增
    void insert(Student... students) {
        studentDao.insert(students);
    }

    // 删
    void delete(Student student) {
        studentDao.delete(student);
    }

    // 改
    void update(Student student) {
        studentDao.update(student);
    }

    // 查 等下不同，因为他没有灵活
    List<Student> getAll() {
        return studentDao.getAll();
    }

    // 查 关联 LiveData 暴露环节
    LiveData<List<Student>> getAllLiveDataStudent() {
        return studentDao.getAllLiveDataStudent();
    }
}
