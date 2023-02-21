package com.xiongtao.use_custom_dagger2.apt_create_dagger2;

import com.xiongtao.custom_dagger2.Preconditions;
import com.xiongtao.use_custom_dagger2.MainActivity;
import com.xiongtao.use_custom_dagger2.StudentComponent;
import com.xiongtao.use_custom_dagger2.StudentModule;
@SuppressWarnings({
        "unchecked",
        "rawtypes",
        "KotlinInternal",
        "KotlinInternalInJava"
})
public final class DaggerStudentComponent {
  private DaggerStudentComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static StudentComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private StudentModule studentModule;

    private Builder() {
    }

    public Builder StudentModule(StudentModule studentModule) {
      this.studentModule = Preconditions.checkNotNull(studentModule);
      return this;
    }

    public StudentComponent build() {
      if (studentModule == null) {
        this.studentModule = new StudentModule();
      }
      return new StudentComponentImpl(studentModule);
    }
  }

  private static final class StudentComponentImpl implements StudentComponent {
    private final StudentModule studentModule;

    private final StudentComponentImpl StudentComponentImpl = this;

    private StudentComponentImpl(StudentModule studentModuleParam) {
      this.studentModule = studentModuleParam;

    }

    @Override
    public void inject(MainActivity mainActivity) {
      injectMainActivity(mainActivity);
    }

    private MainActivity injectMainActivity(MainActivity instance) {
      MainActivity_MembersInjector.injectStudent(instance, StudentModule_ProviderStudentFactory.providerStudent(studentModule));
      return instance;
    }
  }
}