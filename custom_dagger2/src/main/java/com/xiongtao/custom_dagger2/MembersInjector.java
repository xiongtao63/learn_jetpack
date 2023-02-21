package com.xiongtao.custom_dagger2;

public interface MembersInjector<T> {

  // T == 我们要把对象注入到  MainActivity.this那里  MainActivity110那里
  void injectMembers(T instance);
}
