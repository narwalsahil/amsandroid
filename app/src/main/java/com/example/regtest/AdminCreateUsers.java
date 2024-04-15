package com.example.regtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdminCreateUsers extends AppCompatActivity {

    Button btnCreateUser;
    EditText ename,eusername,epassword,egender,emobile,eemail,eaddress,einstitute;
    CheckBox chkAdmin,chksubadmin;
    int estatus=0;
    String url = "https://techlumia.in/loginapp/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_create_users);

        btnCreateUser = findViewById(R.id.edtCreate);
        ename = findViewById(R.id.edtName);
        eusername = findViewById(R.id.edtUsername);
        epassword = findViewById(R.id.edtPassword);
        egender = findViewById(R.id.edtGender);
        emobile = findViewById(R.id.edtMobile);
        eemail = findViewById(R.id.edtEmail);
        eaddress = findViewById(R.id.edtAddress);
        einstitute = findViewById(R.id.edtInstitute);
        chkAdmin = findViewById(R.id.checkAdmin);
        chksubadmin = findViewById(R.id.checkSubAdmin);


        chkAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkAdmin.isChecked()){
                    estatus = 1;
                    chksubadmin.setChecked(false);
                } else{
                    estatus = 0;
                }
            }
        });
        chksubadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chksubadmin.isChecked()){
                    estatus=2;
                    chkAdmin.setChecked(false);
                }
                else {
                    estatus=0;
                }
            }
        });


        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process();
            }
        });
    }
    public void process() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiAdmnCrtUsr api = retrofit.create(apiAdmnCrtUsr.class);
        Call<modelAdmnCrtUsr> call = api.addData(ename.getText().toString(),eusername.getText().toString(),epassword.getText().toString(),String.valueOf(estatus),eaddress.getText().toString(),egender.getText().toString(),emobile.getText().toString(),eemail.getText().toString(),einstitute.getText().toString());
        call.enqueue(new Callback<modelAdmnCrtUsr>() {
            @Override
            public void onResponse(Call<modelAdmnCrtUsr> call, Response<modelAdmnCrtUsr> response) {
                ename.setText("");
                eusername.setText("");
                epassword.setText("");
                eaddress.setText("");
                egender.setText("");
                emobile.setText("");
                eemail.setText("");
                einstitute.setText("");
                estatus=0;
                chkAdmin.setChecked(false);
                chksubadmin.setChecked(false);
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<modelAdmnCrtUsr> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });




    }
}