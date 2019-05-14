package com.codeinger.mvvmexample.app;

import android.app.Application;
import android.content.Context;

import com.codeinger.mvvmexample.di.component.AppComponent;
import com.codeinger.mvvmexample.di.component.ComponentFactory;

public class MainApplication extends Application {

    public static Application appContext;
    public static AppComponent appComponent = null;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        createComponent();
    }

    private void createComponent() {
        if(appComponent==null){
            appComponent = ComponentFactory.create(this);
        }
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }

    public static Application getAppContext(){
        return appContext;
    }
}
