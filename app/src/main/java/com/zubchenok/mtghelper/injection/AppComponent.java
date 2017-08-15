package com.zubchenok.mtghelper.injection;

import com.zubchenok.mtghelper.ui.base.BaseFragment;
import com.zubchenok.mtghelper.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {UtilsModule.class})
@Singleton
public interface AppComponent {

    void inject(MainActivity activity);
    void inject(BaseFragment fragment);

}
