package com.example.regtest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class signup extends AppCompatActivity {

    Button chkSignup;
    EditText ename,eusername,epassword,egender,emobile,eemail,eaddress,einstitute;
    String url = "https://techlumia.in/loginapp/";
    Intent iNext;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        chkSignup = findViewById(R.id.edtSignup);
        ename = findViewById(R.id.edtName);
        eusername = findViewById(R.id.edtUsername);
        epassword = findViewById(R.id.edtPassword);
        egender = findViewById(R.id.edtGender);
        emobile = findViewById(R.id.edtMobile);
        eemail = findViewById(R.id.edtEmail);
        eaddress = findViewById(R.id.edtAddress);
        einstitute = findViewById(R.id.edtInstitute);

        chkSignup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

//                process1();
                do_send_otp_fn(eemail.getText().toString().trim());
//                process();
            }
        });


    }

    private void do_send_otp_fn(String email) {
        String baseUrl = "https://techlumia.in/loginapp/send_OTP_User.php";
        String qry = baseUrl + "?email=" + email;

        class DbProcess extends AsyncTask<String, Void, String> {
            @Override
            protected void onPostExecute(String data) {
               // Toast.makeText(signup.this,""+data , Toast.LENGTH_LONG).show();
                try {
                    JSONObject jsonResponse = new JSONObject(data);

                    // Assuming "response" is the key in your JSON
                    String responseMessage = jsonResponse.getString("otp");

                    if (responseMessage.equals("")) {
                        Toast.makeText(signup.this, "Please Try again", Toast.LENGTH_SHORT).show();
                    } else{
                        //Check User Type
                        // Move this outside of onResponse
                        iNext = new Intent(signup.this, User_OTP_SEND.class);
                        iNext.putExtra("ename",ename.getText().toString().trim());
                        iNext.putExtra("eusername",eusername.getText().toString().trim());
                        iNext.putExtra("epassword",epassword.getText().toString().trim());
                        iNext.putExtra("egender",egender.getText().toString().trim());
                        iNext.putExtra("emobile",emobile.getText().toString().trim());
                        iNext.putExtra("eemail",eemail.getText().toString().trim());
                        iNext.putExtra("eaddress",eaddress.getText().toString().trim());
                        iNext.putExtra("einstitute",einstitute.getText().toString().trim());
                        iNext.putExtra("otp",responseMessage);
                        startActivity(iNext);
                        Toast.makeText(getApplicationContext(),"OTP Sent",Toast.LENGTH_LONG).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(signup.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                String urlString = params[0];

                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    // Set request method to GET
                    conn.setRequestMethod("POST");

                    // Read the response
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    br.close();

                    return response.toString();

                } catch (Exception ex) {
                    return "Error: " + ex.getMessage();
                }
            }
        }

        DbProcess dbProcess = new DbProcess();
        dbProcess.execute(qry);
    }

    private void process1() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiOTPSend api = retrofit.create(apiOTPSend.class);
        Call<modelApiUserSendOTP> call = api.sendOTP(eemail.getText().toString().trim());
        call.enqueue(new Callback<modelApiUserSendOTP>() {
            @Override
            public void onResponse(Call<modelApiUserSendOTP> call, Response<modelApiUserSendOTP> response) {
                // Move this outside of onResponse
                iNext = new Intent(signup.this, User_OTP_SEND.class);
                iNext.putExtra("ename",ename.getText().toString().trim());
                iNext.putExtra("eusername",eusername.getText().toString().trim());
                iNext.putExtra("epassword",epassword.getText().toString().trim());
                iNext.putExtra("egender",egender.getText().toString().trim());
                iNext.putExtra("emobile",emobile.getText().toString().trim());
                iNext.putExtra("eemail",eemail.getText().toString().trim());
                iNext.putExtra("eaddress",eaddress.getText().toString().trim());
                iNext.putExtra("einstitute",einstitute.getText().toString().trim());
                startActivity(iNext);
                Toast.makeText(getApplicationContext(),"OTP Sent",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<modelApiUserSendOTP> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Please try again",Toast.LENGTH_LONG).show();
            }
        });
    }


//    public void process(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        myapi api = retrofit.create(myapi.class);
//        Call<model> call = api.adddata(ename.getText().toString(),eusername.getText().toString(),epassword.getText().toString(),eaddress.getText().toString(),egender.getText().toString(),emobile.getText().toString(),eemail.getText().toString(),einstitute.getText().toString());
//        call.enqueue(new Callback<model>() {
//            @Override
//            public void onResponse(Call<model> call, Response<model> response) {
//                ename.setText("");
//                eusername.setText("");
//                epassword.setText("");
//                eaddress.setText("");
//                egender.setText("");
//                emobile.setText("");
//                eemail.setText("");
//                einstitute.setText("");
//
//                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<model> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
//            }
//        });
//    }

}