package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Welcome_page extends AppCompatActivity {

    TextView welcomeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }

    public void Proceed(View view) {
        welcomeView = findViewById(R.id.welcomePageTextViewId);

        Intent myIntent = new Intent(this, Authentication_page.class);
        startActivity(myIntent);
    }
}