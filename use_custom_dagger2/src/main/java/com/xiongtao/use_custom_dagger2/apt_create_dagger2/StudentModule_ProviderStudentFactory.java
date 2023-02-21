package com.xiongtao.use_custom_dagger2.apt_create_dagger2;

import com.xiongtao.custom_dagger2.Factory;
import com.xiongtao.custom_dagger2.Preconditions;
import com.xiongtao.use_custom_dagger2.Student;
import com.xiongtao.use_custom_dagger2.StudentModule;

final class StudentModule_ProviderStudentFactory implements Factory<Student> {
  private final StudentModule module;

  public StudentModule_ProviderStudentFactory(StudentModule module) {
    this.module = module;
  }

  @Override
  public Student get() {
    return providerStudent(module);
  }

  public static StudentModule_ProviderStudentFactory create(StudentModule module) {
    return new StudentModule_ProviderStudentFactory(module);
  }

  public static Student providerStudent(StudentModule instance) {
    return Preconditions.checkNotNull(instance.providerStudent());
  }
}
