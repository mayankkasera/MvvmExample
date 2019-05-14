package com.codeinger.mvvmexample.api.retrofit;

import java.util.List;

public interface ApiCallback<T> {
    void onSuccess(T t);
    void onFailure(String message);
}
