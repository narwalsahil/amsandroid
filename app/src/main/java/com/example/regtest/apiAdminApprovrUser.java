package com.example.regtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiAdminApprovrUser {
    @GET("Admin_Pending_Request_Approval.php")
    Call<List<modelAdminApprovePendingRequest>> getUserData();

}
