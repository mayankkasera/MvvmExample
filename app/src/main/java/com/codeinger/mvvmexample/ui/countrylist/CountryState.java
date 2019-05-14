package com.codeinger.mvvmexample.ui.countrylist;

import com.codeinger.mvvmexample.api.pojo.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryState {

    private Boolean isLoading = false;
    private Boolean countryListSuccess = false;
    private String message = "";
    private List<Country> countries = new ArrayList<>();

    public CountryState(Boolean isLoading, Boolean countryListSuccess, String message, List<Country> countries) {
        this.isLoading = isLoading;
        this.countryListSuccess = countryListSuccess;
        this.message = message;
        this.countries = countries;
    }

    public CountryState(Boolean isLoading, Boolean countryListSuccess, String message) {
        this.isLoading = isLoading;
        this.countryListSuccess = countryListSuccess;
        this.message = message;
    }


    public Boolean getLoading() {
        return isLoading;
    }

    public void setLoading(Boolean loading) {
        isLoading = loading;
    }

    public Boolean getCountryListSuccess() {
        return countryListSuccess;
    }

    public void setCountryListSuccess(Boolean countryListSuccess) {
        this.countryListSuccess = countryListSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public CountryState showLoading() {
        return new CountryState(true, false, "Loading.....");
    }

    public CountryState stopLoading() {
        return new CountryState(false, false, "");
    }

    public CountryState showSuccessCountryList(List<Country> countries) {
        return new CountryState(false, true, "Load Again", countries);
    }

    public CountryState showError(String message) {
        return new CountryState(false, false, message);
    }
}
