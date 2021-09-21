package com.example.buspass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface myapi_2 {

    @POST("select.php")
    Call<List<model>> getmodels();
}
