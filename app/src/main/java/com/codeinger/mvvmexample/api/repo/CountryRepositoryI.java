package com.codeinger.mvvmexample.api.repo;

import com.codeinger.mvvmexample.api.pojo.Country;
import com.codeinger.mvvmexample.api.retrofit.ApiCallback;

import java.util.List;

public interface CountryRepositoryI {
    void getCountryList(ApiCallback<List<Country>> countryList);
}
