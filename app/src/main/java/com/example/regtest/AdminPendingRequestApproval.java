package com.example.regtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminPendingRequestApproval extends AppCompatActivity {

    RecyclerView recviewAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pending_request_approval);
        recviewAdmin = findViewById(R.id.recviewAdmin);
        recviewAdmin.setLayoutManager(new LinearLayoutManager(this));
        processdata();
    }

    private void processdata() {
        Call<List<modelAdminApprovePendingRequest>> call = apicontrollerAdminApproveUser
                .getInstance()
                .getapi()
                .getUserData();
        call.enqueue(new Callback<List<modelAdminApprovePendingRequest>>() {
            @Override
            public void onResponse(Call<List<modelAdminApprovePendingRequest>> call, Response<List<modelAdminApprovePendingRequest>> response) {
                List<modelAdminApprovePendingRequest> data = response.body();
                myadapterAdminApproveUser adapter = new myadapterAdminApproveUser(data,getApplicationContext());
                recviewAdmin.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<modelAdminApprovePendingRequest>> call, Throwable t) {
                Toast.makeText(AdminPendingRequestApproval.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}