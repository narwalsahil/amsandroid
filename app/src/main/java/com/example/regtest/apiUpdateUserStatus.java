package com.example.regtest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiUpdateUserStatus {
    @FormUrlEncoded
    @POST("Admin_Pending_Request_Approval_For_User.php")
    Call<modelUpdateUserStatus> updateUser(@Field("id") String id);

}
