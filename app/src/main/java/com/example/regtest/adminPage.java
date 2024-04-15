package com.example.regtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class adminPage extends AppCompatActivity {


    Intent seeUsersNext,createUserNext,pendingRequestNext;

    Button createUser, pendingRequest, seeUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        createUser = findViewById(R.id.adminCreateUser);
        pendingRequest = findViewById(R.id.adminPendingRequest);
        seeUsers = findViewById(R.id.adminSeeUsers);


        seeUsersNext = new Intent(adminPage.this, AdminShowUsers.class);
        seeUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(seeUsersNext);
            }
        });

        createUserNext = new Intent(adminPage.this,AdminCreateUsers.class);
        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createUserNext);
            }
        });

        pendingRequestNext = new Intent(adminPage.this, AdminPendingRequestApproval.class);
        pendingRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(pendingRequestNext);
            }
        });



    }
}