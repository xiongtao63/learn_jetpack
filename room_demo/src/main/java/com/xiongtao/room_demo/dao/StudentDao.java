package com.xiongtao.room_demo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.xiongtao.room_demo.entity.Student;
import com.xiongtao.room_demo.entity.StudentTuple;

import java.sql.Struct;
import java.util.List;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-10 15:37
 */
@Dao
public interface StudentDao {

    @Insert
    void insert(Student... students);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);

    @Query("select * from Student")
    List<Student> getAll();

    @Query("select * from Student where name like:name")
    Student findByName(String name);

    @Query("select * from student where uid in(:userIds)")
    List<Student> getAllId(int[] userIds);
    // 就是查询 name pwd  给 StudentTuple 类接收
    @Query("select name,pwd from Student")
    StudentTuple getRecord();


    // 使用 LiveData 关联 Room
    @Query("select * from Student order by uid")
    LiveData<List<Student>> getAllLiveDataStudent();
}
