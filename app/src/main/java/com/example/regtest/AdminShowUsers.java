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


public class AdminShowUsers extends AppCompatActivity {

    RecyclerView recview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_show_users);
        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));
        processdata();
    }
    public void processdata() {
        Call<List<userPageModel>> call= apicontroller
                .getInstance()
                .getapi()
                .getUserData();

        call.enqueue(new Callback<List<userPageModel>>() {
            @Override
            public void onResponse(Call<List<userPageModel>> call, Response<List<userPageModel>> response) {
                List<userPageModel> data = response.body();
                myadapter adapter = new myadapter(data);
                recview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<userPageModel>> call, Throwable t) {
                Toast.makeText(AdminShowUsers.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}