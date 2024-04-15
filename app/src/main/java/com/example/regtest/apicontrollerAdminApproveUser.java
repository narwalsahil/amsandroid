package com.example.regtest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apicontrollerAdminApproveUser {
    private static final String url = "https://techlumia.in/loginapp/";
    private static apicontrollerAdminApproveUser clientobject;
    private static Retrofit retrofit;
    apicontrollerAdminApproveUser(){
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized apicontrollerAdminApproveUser getInstance(){
        if(clientobject==null) {
            clientobject = new apicontrollerAdminApproveUser();
        }
        return clientobject;
    }

    apiAdminApprovrUser getapi(){
        return retrofit.create(apiAdminApprovrUser.class);
    }
}
