package com.codeinger.mvvmexample;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {

    public static Application appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    public static Application getAppContext(){
        return appContext;
    }
}
