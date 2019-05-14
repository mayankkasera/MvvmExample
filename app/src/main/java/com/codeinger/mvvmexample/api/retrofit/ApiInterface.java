package com.codeinger.mvvmexample.api.retrofit;

import com.codeinger.mvvmexample.api.pojo.Country;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    // Request method and URL Given in the notation
    @GET("/wp-content/uploads/2019/03/world-population-androchef.txt")
    Observable<List<Country>> loadWordPopulationList();
}
