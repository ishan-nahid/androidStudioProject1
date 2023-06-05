package com.example.lab_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class user_login extends Fragment {

    View viewout;
    EditText ID, PASS;
    Button LOGINBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewout = inflater.inflate(R.layout.fragment_user_login, container, false);

        ID = viewout.findViewById(R.id.idNumberId);
        PASS = viewout.findViewById(R.id.loginPagePasswordId);

        LOGINBtn = viewout.findViewById(R.id.loginPageSubmitBtnId);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference data = db.getReference("Users");

        LOGINBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_id = ID.getText().toString();

                String user_password = PASS.getText().toString();

                data.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String passFromDB = snapshot.child(user_id).child("password").getValue(String.class);

                        if(passFromDB.equals(user_password))
                        {
                            Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();

                            Intent myIntent = new Intent(getActivity(), Spinner_page.class);
                            startActivity(myIntent);
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });





        return viewout;
    }
}