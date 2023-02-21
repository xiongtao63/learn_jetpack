package com.xiongtao.use_custom_dagger2;

import com.xiongtao.custom_dagger2.annotation.Module;
import com.xiongtao.custom_dagger2.annotation.Provides;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 17:14
 */
@Module
public class StudentModule {

    @Provides
    public Student providerStudent() {
        return new Student();
    }
}

