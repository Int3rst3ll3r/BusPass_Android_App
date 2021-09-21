package com.example.buspass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface myapi {
    @FormUrlEncoded
    @POST("insert_db.php")

    Call<model> adddata(@Field("company") String company, @Field("model") String model, @Field("variant") String variant,
                        @Field("year") String year, @Field("color") String color, @Field("kmdriven") String kmdriven,
                        @Field("owner") String owner, @Field("state") String state, @Field("city") String city,
                        @Field("price") String price, @Field("description") String description);

}
