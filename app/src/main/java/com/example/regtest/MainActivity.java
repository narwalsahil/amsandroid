    package com.example.regtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

    public class MainActivity extends AppCompatActivity {

        EditText usernameinp , passinpt;
        Intent iNextSignup,iNextUser,iNextAdmin,iNextSubadmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Finding the IDs of Input Fields
        usernameinp = findViewById(R.id.txtID);
        passinpt = findViewById(R.id.txtPass);

        Button btnlogin;
        btnlogin = findViewById(R.id.btnLogin);


        Button btnSignUP;
        View btnSignUp = findViewById(R.id.btnSignup);

        iNextSignup = new Intent(MainActivity.this, signup.class);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iNextSignup);
            }
        });


    }

        public void login_fn(View view) {

            if(usernameinp.getText().toString().trim().isEmpty())
            {
                Toast.makeText(this,"Enter Valid Username", Toast.LENGTH_LONG).show();
            } else if (passinpt.getText().toString().trim().isEmpty()) {
                Toast.makeText(this,"Enter Valid Password", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Verifying Login Credentials!", Toast.LENGTH_SHORT).show();
                // Calling Login Method by Passing username and pass as parameter
                do_login_fn(usernameinp.getText().toString().trim(),passinpt.getText().toString().trim());
            }

        }

        private void do_login_fn(String username, String password) {
            String baseUrl = "https://techlumia.in/loginapp/loginapi.php";
            String qry = baseUrl + "?username=" + username + "&password=" + password;

            class DbProcess extends AsyncTask<String, Void, String> {
                @Override
                protected void onPostExecute(String data) {
                    try {
                        JSONObject jsonResponse = new JSONObject(data);

                        // Assuming "response" is the key in your JSON
                        String responseMessage = jsonResponse.getString("response");

                        if (responseMessage.equals("Invalid Credentials")) {
                            Toast.makeText(MainActivity.this, "Invalid Login Details!- Please Try again", Toast.LENGTH_SHORT).show();
                        } else if(responseMessage.equals("exist")){
                            //Check User Type
                            String status_label = jsonResponse.getString("status");
                            String status_code = jsonResponse.getString("statuscode");
                            String User_Id = jsonResponse.getString("userId");
                            String User_Name = jsonResponse.getString("nameuser");
                            String User_Address = jsonResponse.getString("addressuser");
                            String User_Gender = jsonResponse.getString("genderuser");
                            String User_Mobile = jsonResponse.getString("mobileuser");
                            String User_Email = jsonResponse.getString("emailuser");
                            String User_Institute = jsonResponse.getString("instituteuser");


                            if(status_code.equals("1")){
                                //GOTO ADMIN
                                Toast.makeText(MainActivity.this, "Account Status : "+status_label, Toast.LENGTH_SHORT).show();
                                iNextAdmin = new Intent(MainActivity.this, adminPage.class);
                                int g = 10;
                                iNextAdmin.putExtra("G",g);
                                startActivity(iNextAdmin);
                            } else if(status_code.equals("2")){
                                //GOTO SubAdmin
                                Toast.makeText(MainActivity.this, "Account Status : "+status_label, Toast.LENGTH_SHORT).show();
                                iNextSubadmin = new Intent(MainActivity.this, subAdminPage.class);
//                                iNextSubadmin.putExtra("usrname",usernameinp.getText().toString().trim());
                                startActivity(iNextSubadmin);
                            } else if(status_code.equals("0")){
                                //GOTO User
                                Toast.makeText(MainActivity.this, "Account Status : "+status_label, Toast.LENGTH_SHORT).show();
                                iNextUser = new Intent(MainActivity.this, UserDataAccess.class);
                                iNextUser.putExtra("usrname",usernameinp.getText().toString().trim());
                                iNextUser.putExtra("usrId",User_Id);
                                iNextUser.putExtra("usr_Name",User_Name);
                                iNextUser.putExtra("usrAddress",User_Address);
                                iNextUser.putExtra("usrGender",User_Gender);
                                iNextUser.putExtra("usrMobile",User_Mobile);
                                iNextUser.putExtra("usrEmail",User_Email);
                                iNextUser.putExtra("usrInstitute",User_Institute);
                                startActivity(iNextUser);
                            } else if(status_code.equals("3")){
                                //GOTO User
                                Toast.makeText(MainActivity.this, "Account Status : "+status_label, Toast.LENGTH_SHORT).show();
                            } else if(status_code.equals("4")){
                                //Show Blocked
                                Toast.makeText(MainActivity.this, "Account Status : "+status_label, Toast.LENGTH_SHORT).show();
                            }

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                protected String doInBackground(String... params) {
                    String urlString = params[0];

                    try {
                        URL url = new URL(urlString);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        // Set request method to GET
                        conn.setRequestMethod("GET");

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


    }