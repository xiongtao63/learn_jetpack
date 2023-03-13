package com.xiongtao.room_demo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.xiongtao.room_demo.entity.Student;

import java.util.List;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-10 17:29
 */
public class StudentViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
    }

    // 增
    void insert(Student... students) {
        studentRepository.insert(students);
    }

    // 删
    void delete(Student student) {
        studentRepository.delete(student);
    }

    // 改
    void update(Student student) {
        studentRepository.update(student);
    }

    // 查 等下不同，因为他没有灵活
    List<Student> getAll() {
        return studentRepository.getAll();
    }

    // 查 关联 LiveData  【相当于 我的 ViewModel 也有同一份 LiveData】
    LiveData<List<Student>> getAllLiveDataStudent() {
        return studentRepository.getAllLiveDataStudent();
    }
}
