package com.codeinger.mvvmexample.api.repo;

import com.codeinger.mvvmexample.MainApplication;
import com.codeinger.mvvmexample.api.pojo.Country;
import com.codeinger.mvvmexample.api.retrofit.ApiCallback;
import com.codeinger.mvvmexample.api.retrofit.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class CountryRepository implements CountryRepositoryI {

    @Inject
    Retrofit mRetrofit;

    private ApiInterface countryApi;

    public CountryRepository() {
        MainApplication.getAppComponent().inject(this);
        countryApi = mRetrofit.create(ApiInterface.class);
    }

    @Override
    public void getCountryList(final ApiCallback<List<Country>> callback) {
        countryApi.loadWordPopulationList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Country>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Country> countries) {
                        if (countries.isEmpty())
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
