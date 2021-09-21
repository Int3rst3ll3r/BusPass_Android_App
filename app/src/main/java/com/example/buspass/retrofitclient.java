package com.example.buspass;

import Api.api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitclient {

    private static String BASE_URL="https://buspasswithqr.000webhostapp.com/My%20Database/";

    private static retrofitclient rclient;

    private static Retrofit retrofit;

    private  retrofitclient()
    {
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized retrofitclient getInstance() {

        if(rclient==null) {
            rclient=new retrofitclient();

        }
        return rclient;
    }

    public api getApi()

    {
        return retrofit.create(api.class);
    }
}
