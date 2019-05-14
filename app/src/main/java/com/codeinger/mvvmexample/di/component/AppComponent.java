package com.codeinger.mvvmexample.di.component;

import com.codeinger.mvvmexample.api.repo.CountryRepository;
import com.codeinger.mvvmexample.di.modules.ApplicationModule;
import com.codeinger.mvvmexample.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(CountryRepository countryRepository);
}
