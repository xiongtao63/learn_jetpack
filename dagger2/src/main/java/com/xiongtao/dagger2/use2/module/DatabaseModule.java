package com.xiongtao.dagger2.use2.module;

import com.xiongtao.dagger2.use2.obj.DatabaseObject;

import dagger.Module;
import dagger.Provides;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-20 14:25
 */
@Module
public class DatabaseModule {

    @Provides
    public DatabaseObject providerDatabaseObject(){
        return new DatabaseObject();
    }
}
