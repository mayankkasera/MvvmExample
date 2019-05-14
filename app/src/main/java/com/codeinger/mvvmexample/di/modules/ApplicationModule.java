package com.codeinger.mvvmexample.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application ){
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return  application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return  application;
    }

}
