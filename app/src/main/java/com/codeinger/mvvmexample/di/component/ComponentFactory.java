package com.codeinger.mvvmexample.di.component;

import com.codeinger.mvvmexample.MainApplication;
import com.codeinger.mvvmexample.di.modules.ApplicationModule;
import com.codeinger.mvvmexample.di.modules.NetworkModule;

public class ComponentFactory {

    public static AppComponent create(MainApplication application) {
        return DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .networkModule(new NetworkModule())
                .build();
    }
}
