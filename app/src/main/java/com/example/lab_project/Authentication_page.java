package com.example.lab_project;

import static com.example.lab_project.R.id.frameLayoutId;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Authentication_page extends AppCompatActivity {

    Button loginPage, registrationPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication_page);

        loginPage = findViewById(R.id.loginBtnId);
        registrationPage = findViewById(R.id.registrationBtnId);

        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replace(new user_login());
            }
        });

        registrationPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replace(new user_registration());
            }
        });
    }

    private void replace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId, fragment);
        fragmentTransaction.commit();
    }

}