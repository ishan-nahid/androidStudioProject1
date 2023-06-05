package com.example.lab_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class user_registration extends Fragment {

    View viewOut;
    EditText Name, PassWord, Email, Id;
    Button registerBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       viewOut = inflater.inflate(R.layout.fragment_user_registration, container, false);

       Name = viewOut.findViewById(R.id.loginPageUserNameId);
       Id = viewOut.findViewById(R.id.idNumberId);
       Email = viewOut.findViewById(R.id.emailId);
       PassWord = viewOut.findViewById(R.id.loginPagePasswordId);


        registerBtn = viewOut.findViewById(R.id.registerPageSubmitBtnId);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String password = PassWord.getText().toString();

                userRegister userInfo = new userRegister(name, email, password);

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference root = db.getReference("Users");

                root.child(id).setValue(userInfo);

                Toast.makeText(getActivity(), "Registration Successful", Toast.LENGTH_SHORT).show();


                Name.setText("");
                PassWord.setText("");
                Email.setText("");
                Id.setText("");


            }
        });

/*
Register
FirebaseDatabase db = FirebaseDatabase.getInstance();
DatabaseReference root = db.getReference("Users");
root.child(id).setValue(userInfo);

 */
/*
DatabaseReference db_data = FirebaseDatabase.getInstance().getReference();
db_data.child("Users);
 */


//





       return viewOut;
    }
}