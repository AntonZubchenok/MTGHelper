package com.zubchenok.mtghelper;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.zubchenok.mtghelper.injection.AppComponent;
import com.zubchenok.mtghelper.injection.DaggerAppComponent;
import com.zubchenok.mtghelper.injection.UtilsModule;

public class App extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = buildComponent();
        initializeStetho();
    }

    private void initializeStetho() {
        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));
        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));
        Stetho.Initializer initializer = initializerBuilder.build();
        Stetho.initialize(initializer);
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder().utilsModule(new UtilsModule()).build();
    }

    public static AppComponent getComponent() {
        return component;
    }

}
