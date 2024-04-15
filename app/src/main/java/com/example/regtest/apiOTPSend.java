package com.example.regtest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiOTPSend {
    @FormUrlEncoded
    @POST("send_OTP_User.php")
    Call<modelApiUserSendOTP> sendOTP(@Field("email") String email);
}
