package com.codeinger.mvvmexample.ui.countrylist;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codeinger.mvvmexample.api.pojo.Country;
import com.codeinger.mvvmexample.api.repo.CountryRepository;
import com.codeinger.mvvmexample.api.repo.CountryRepositoryI;
import com.codeinger.mvvmexample.api.retrofit.ApiCallback;

import java.util.ArrayList;
import java.util.List;

public class CountryListViewModel extends ViewModel {


    private CountryRepositoryI repositoryI;
    MutableLiveData<CountryState> state = new MutableLiveData<>();

    public CountryListViewModel() {
        state.setValue(
                new CountryState(
                        false,
                        false,
                        "",
                        new ArrayList<Country>()
                ));
    }


    void setRepositoryI(CountryRepositoryI countryRepositoryI){
        this.repositoryI = countryRepositoryI;
    }

    void getCountryList() {
        state.setValue(state.getValue().showLoading());
        repositoryI.getCountryList(new ApiCallback<List<Country>>() {
            @Override
            public void onSuccess(List<Country> countries) {
                state.setValue(state.getValue().showSuccessCountryList(countries));
            }

            @Override
            public void onFailure(String message) {
                state.setValue(state.getValue().showError(message));
            }
        });
    }
}
