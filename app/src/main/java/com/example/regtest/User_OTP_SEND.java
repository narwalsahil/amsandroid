package com.example.regtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class User_OTP_SEND extends AppCompatActivity {

    String url = "https://techlumia.in/loginapp/";
    EditText enterOTP;
    Button verifyOTP;
    String ename,eusername,epassword,egender,emobile,eemail,eaddress,einstitute,otp;
    Intent iReceive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_otp_send);


        enterOTP = findViewById(R.id.enter_OTP);
        verifyOTP = findViewById(R.id.btnVerifyOTP);
        iReceive = getIntent();
        ename = iReceive.getStringExtra("ename");
        eusername = iReceive.getStringExtra("eusername");
        epassword = iReceive.getStringExtra("epassword");
        egender = iReceive.getStringExtra("egender");
        emobile = iReceive.getStringExtra("emobile");
        eemail = iReceive.getStringExtra("eemail");
        eaddress = iReceive.getStringExtra("eaddress");
        einstitute = iReceive.getStringExtra("einstitute");
        otp = iReceive.getStringExtra("otp");

        verifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enterOTP.getText().toString().trim().equals(otp.toString().trim())){
                    process();
                }
                else{
                    Toast.makeText(User_OTP_SEND.this,"Invalid OTP",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public void process(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myapi api = retrofit.create(myapi.class);
        Call<model> call = api.adddata(ename,eusername,epassword,eaddress,egender,emobile,eemail,einstitute,enterOTP.getText().toString().trim());
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {

                Toast.makeText(getApplicationContext(),"OTP Verified and wait for approval",Toast.LENGTH_LONG).show();
                enterOTP.setText("XXXX");
                verifyOTP.setText("OTP Verified!");
                verifyOTP.setClickable(false);

            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}