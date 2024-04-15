package com.example.regtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myGetApi {

    @GET("getData.php")
    Call<List<userPageModel>> getUserData();



}
