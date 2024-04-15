package com.example.regtest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiUpdateSubAdminStatus {
    @FormUrlEncoded
    @POST("Admin_Pending_Request_Approval_For_SubAdmin.php")
        Call<modelUpdateUserStatus> updatesubadmin(@Field("id") String id);
}
