package com.codeinger.mvvmexample.ui.countrylist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codeinger.mvvmexample.api.pojo.Country;
import com.codeinger.mvvmexample.api.repo.CountryRepositary;
import com.codeinger.mvvmexample.api.repo.CountryRepositaryI;
import com.codeinger.mvvmexample.api.retrofit.ApiCallback;

import java.util.List;

public class CountryListViewModel extends ViewModel {

    private CountryRepositary repository = new CountryRepositary();

    MutableLiveData<List<Country>> listLiveData = new MutableLiveData<>();


    void getCountryList(){
        repository.getCountryList(new ApiCallback<List<Country>>() {
            @Override
            public void onSuccess(List<Country> countries) {
                listLiveData.setValue(countries);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
