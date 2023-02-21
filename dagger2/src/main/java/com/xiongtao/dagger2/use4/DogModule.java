package com.xiongtao.dagger2.use4;

import dagger.Module;
import dagger.Provides;

@Module
public class DogModule {

    @Provides
    public Dog providerDog() {
        return new Dog();
    }

}
