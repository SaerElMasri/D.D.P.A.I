package com.example.seniorproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder> {

    private Context context;
    private ArrayList contact_name;
    private ArrayList contact_phone;

    Activity activity;

    customAdapter(Activity activity, Context context, ArrayList contact_name, ArrayList contact_phone){
        this.activity = activity;
        this.context = context;
        this.contact_name = contact_name;
        this.contact_phone = contact_phone;
    }

    @NonNull
    @Override
    public customAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.contactName.setText(String.valueOf(contact_name.get(position)));
        holder.contactPhone.setText(String.valueOf(contact_phone.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateContact.class);
                intent.putExtra("contactName", (String.valueOf(contact_name.get(position))));
                intent.putExtra("contactPhone", String.valueOf(contact_phone.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return contact_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView contactName, contactPhone;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactName_text);
            contactPhone = itemView.findViewById(R.id.contactNumber_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
