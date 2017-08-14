package com.zubchenok.mtghelper;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.zubchenok.mtghelper.util.ActivityUtils;


public class MTGHelperApplication extends Application {

    private static MTGHelperApplication instance;

    private ActivityUtils activityUtils;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        initializeStetho();
        initializeSingletons();
    }

    private void initializeStetho() {
        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));
        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));
        Stetho.Initializer initializer = initializerBuilder.build();
        Stetho.initialize(initializer);
    }

    private void initializeSingletons() {
        activityUtils = ActivityUtils.getInstance();
    }

    public ActivityUtils getActivityUtils() {
        return activityUtils;
    }

    public static MTGHelperApplication getApp() {
        return instance;
    }

}
