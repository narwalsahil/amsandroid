package com.example.regtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserDataAccess extends AppCompatActivity {
    TextView getusrid,username,userName,userAddress,userGender,userMobile,userEmail,userInstitute;
    Intent rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_access);

        rcv = getIntent();
        String rcvDataname = rcv.getStringExtra("usrname");
        String rcvDataId = rcv.getStringExtra("usrId");
        String rcvDataName = rcv.getStringExtra("usr_Name");
        String rcvDataAddress = rcv.getStringExtra("usrAddress");
        String rcvDataGender = rcv.getStringExtra("usrGender");
        String rcvDataMobile = rcv.getStringExtra("usrMobile");
        String rcvDataEmail = rcv.getStringExtra("usrEmail");
        String rcvDataInstitute = rcv.getStringExtra("usrInstitute");

        getusrid = findViewById(R.id.edtusrid);
        username = findViewById(R.id.edtusrname);
        userName = findViewById(R.id.edtusrName);
        userAddress = findViewById(R.id.edtusrAddress);
        userGender = findViewById(R.id.edtusrGender);
        userMobile = findViewById(R.id.edtusrMobile);
        userEmail = findViewById(R.id.edtusrEmail);
        userInstitute = findViewById(R.id.edtusrInstitute);
        getusrid.setText("User Id : "+rcvDataId);
        username.setText("username : "+rcvDataname);
        userName.setText("Name : "+rcvDataName);
        userAddress.setText("Address : "+rcvDataAddress);
        userGender.setText("Gender : "+rcvDataGender);
        userMobile.setText("Mobile : "+rcvDataMobile);
        userEmail.setText("Email : "+rcvDataEmail);
        userInstitute.setText("Institute : "+rcvDataInstitute);

    }
}