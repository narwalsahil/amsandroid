package com.example.regtest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apicontroller {

    private static final String url = "https://techlumia.in/loginapp/";
    private static apicontroller clientobject;
    private static Retrofit retrofit;


    apicontroller(){



        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized apicontroller getInstance(){
        if(clientobject==null) {
            clientobject = new apicontroller();
        }

        return clientobject;
    }

    myGetApi getapi(){
        return retrofit.create(myGetApi.class);
    }

}
