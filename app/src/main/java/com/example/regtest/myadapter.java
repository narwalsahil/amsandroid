package com.example.regtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{
    List<userPageModel> data;

    public myadapter(List<userPageModel> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleroedesign,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.idId.setText(data.get(position).getId());
        holder.idName.setText(data.get(position).getName());
        holder.idUsername.setText(data.get(position).getUsername());
        holder.idAddress.setText(data.get(position).getAddress());
        holder.idGender.setText(data.get(position).getGender());
        holder.idMobile.setText(data.get(position).getMobile());
        holder.idEmail.setText(data.get(position).getEmail());
        holder.idInstitution.setText(data.get(position).getInstitution());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class myviewholder extends RecyclerView.ViewHolder{
        TextView idId,idName,idUsername,idAddress,idGender,idMobile,idEmail,idInstitution;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            idId=itemView.findViewById(R.id.idId);
            idName=itemView.findViewById(R.id.idName);
            idUsername=itemView.findViewById(R.id.idUsername);
            idAddress=itemView.findViewById(R.id.idAddress);
            idGender=itemView.findViewById(R.id.idGender);
            idMobile=itemView.findViewById(R.id.idMobile);
            idEmail=itemView.findViewById(R.id.idEmail);
            idInstitution=itemView.findViewById(R.id.idInstitution);
        }
    }
}
