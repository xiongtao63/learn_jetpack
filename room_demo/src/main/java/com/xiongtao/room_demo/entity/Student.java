package com.xiongtao.room_demo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-10 14:39
 */
@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "pwd")
    private String password;

    @ColumnInfo(name = "address")
    private int address;

    public Student(int uid, String name, String password, int addressId) {
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.address = addressId;
    }

    public Student() {
    }

    public Student(String name, String password, int address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}
