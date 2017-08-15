package com.zubchenok.mtghelper.injection;

import com.zubchenok.mtghelper.util.ActivityUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Provides
    @Singleton
    ActivityUtils provideActivityUtils() {
        return new ActivityUtils();
    }
}
