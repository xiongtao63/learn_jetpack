package com.xiongtao.use_custom_dagger2.apt_create_dagger2;

import com.xiongtao.custom_dagger2.Factory;
import com.xiongtao.use_custom_dagger2.Student;




@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
final class Student_Factory implements Factory<Student> {
  @Override
  public Student get() {
    return newInstance();
  }

  public static Student_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Student newInstance() {
    return new Student();
  }

  private static final class InstanceHolder {
    private static final Student_Factory INSTANCE = new Student_Factory();
  }
}
