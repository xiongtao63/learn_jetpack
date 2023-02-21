package com.xiongtao.use_custom_dagger2.apt_create_dagger2;

import com.xiongtao.custom_dagger2.MembersInjector;
import com.xiongtao.custom_dagger2.Provider;
import com.xiongtao.use_custom_dagger2.MainActivity;
import com.xiongtao.use_custom_dagger2.Student;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<Student> StudentProvider;

  public MainActivity_MembersInjector(Provider<Student> StudentProvider) {
    this.StudentProvider = StudentProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<Student> StudentProvider) {
    return new MainActivity_MembersInjector(StudentProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectStudent(instance, StudentProvider.get());
  }

//  @InjectedFieldSignature("com.xiongtao.dagger2.use4.MainActivity.Student")
  public static void injectStudent(MainActivity instance, Student Student) {
    instance.student = Student;
    instance.student2 = Student;
  }
}
