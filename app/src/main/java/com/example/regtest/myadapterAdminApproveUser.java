package com.example.regtest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class myadapterAdminApproveUser extends RecyclerView.Adapter<myadapterAdminApproveUser.myviewholder> {


    List<modelAdminApprovePendingRequest> data;
    Context context;
    String url = "https://techlumia.in/loginapp/";
    String tempString;


    public myadapterAdminApproveUser(List<modelAdminApprovePendingRequest> data,Context context) {
        this.data = data;
        this.context = context;

    }



    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesignadminapproval,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final modelAdminApprovePendingRequest temp = data.get(position);
        holder.idId.setText(data.get(position).getId());
        holder.idName.setText(data.get(position).getName());
        holder.idUsername.setText(data.get(position).getUsername());
        holder.idAddress.setText(data.get(position).getAddress());
        holder.idGender.setText(data.get(position).getGender());
        holder.idMobile.setText(data.get(position).getMobile());
        holder.idEmail.setText(data.get(position).getEmail());
        holder.clickForUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempString = temp.getId();
//                Toast.makeText(context, tempString, Toast.LENGTH_SHORT).show();
//                Intent inext = new Intent(context,AdminApproveUpdateUserStatus.class);
//                inext.putExtra("tempValue",tempString);
//                inext.putExtra("view", (CharSequence) v);
//                context.startActivity(inext);
                process();

            }
        });
        holder.clickForSubAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempString = temp.getId();
                process1();
            }
        });

    }

    private void process1() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiUpdateSubAdminStatus api = retrofit.create(apiUpdateSubAdminStatus.class);
        Call<modelUpdateUserStatus> call = api.updatesubadmin(tempString);
        call.enqueue(new Callback<modelUpdateUserStatus>() {
            @Override
            public void onResponse(Call<modelUpdateUserStatus> call, Response<modelUpdateUserStatus> response) {
                Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<modelUpdateUserStatus> call, Throwable t) {
                Toast.makeText(context,t.toString(),Toast.LENGTH_LONG).show();
            }
        });



    }

    private void process() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiUpdateUserStatus api = retrofit.create(apiUpdateUserStatus.class);
        Call<modelUpdateUserStatus> call = api.updateUser(tempString);
        call.enqueue(new Callback<modelUpdateUserStatus>() {
            @Override
            public void onResponse(Call<modelUpdateUserStatus> call, Response<modelUpdateUserStatus> response) {
                Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<modelUpdateUserStatus> call, Throwable t) {
                Toast.makeText(context,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView idId,idName,idUsername,idAddress,idGender,idMobile,idEmail,idInstitution;
        Button clickForUser,clickForSubAdmin;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            idId = itemView.findViewById(R.id.idId);
            idName = itemView.findViewById(R.id.idName);
            idUsername = itemView.findViewById(R.id.idUsername);
            idAddress = itemView.findViewById(R.id.idAddress);
            idGender = itemView.findViewById(R.id.idGender);
            idMobile = itemView.findViewById(R.id.idMobile);
            idEmail = itemView.findViewById(R.id.idEmail);
            idInstitution = itemView.findViewById(R.id.idInstitution);
            clickForUser = itemView.findViewById(R.id.adminApproveUser);
            clickForSubAdmin = itemView.findViewById(R.id.adminApproveSubAdmin);

        }
    }
}
