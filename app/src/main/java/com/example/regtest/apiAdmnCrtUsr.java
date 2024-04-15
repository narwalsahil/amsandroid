package com.example.regtest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiAdmnCrtUsr {
    @FormUrlEncoded
    @POST("admin_create_users.php")
    Call<modelAdmnCrtUsr> addData(@Field("name") String name,@Field("username") String username,@Field("password") String password,@Field("status") String status,@Field("address") String address,@Field("gender") String gender,@Field("mobile") String mobile,@Field("email") String email,@Field("institute") String institute);
}
