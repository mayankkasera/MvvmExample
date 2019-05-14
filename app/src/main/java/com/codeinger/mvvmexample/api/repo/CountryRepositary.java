package com.codeinger.mvvmexample.api.repo;

import com.codeinger.mvvmexample.MainApplication;
import com.codeinger.mvvmexample.api.pojo.Country;
import com.codeinger.mvvmexample.api.retrofit.ApiCallback;
import com.codeinger.mvvmexample.api.retrofit.ApiInterface;
import com.codeinger.mvvmexample.di.component.AppComponent;
import com.codeinger.mvvmexample.di.component.DaggerAppComponent;
import com.codeinger.mvvmexample.di.modules.ApplicationModule;
import com.codeinger.mvvmexample.di.modules.NetworkModule;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class CountryRepositary implements CountryRepositaryI{

    @Inject
    Retrofit mRetrofit;

    AppComponent appComponent;

    public CountryRepositary(){
      appComponent =  DaggerAppComponent.builder().applicationModule(new ApplicationModule(MainApplication.appContext))
                .networkModule(new NetworkModule())
                .build();
      appComponent.inject(this);
    }

    private ApiInterface countryApi = mRetrofit.create(ApiInterface.class);

    @Override
    public void getCountryList(final ApiCallback<List<Country>> callback) {

        countryApi.loadWordPopulationList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Country>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Country> countries) {
                        if(countries.isEmpty())
                            callback.onFailure("Empty List");
                        else
                            callback.onSuccess(countries);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
