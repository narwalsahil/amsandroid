package com.example.regtest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface myapi {
    @FormUrlEncoded
    @POST("insertData.php")
    Call<model> adddata(@Field("name") String name,@Field("username") String username,@Field("password") String password,@Field("address") String address,@Field("gender") String gender,@Field("mobile") String mobile,@Field("email") String email,@Field("institute") String institute,@Field("otp") String otp);

}
