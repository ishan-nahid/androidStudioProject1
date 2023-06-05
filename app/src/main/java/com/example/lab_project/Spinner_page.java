package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Spinner_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner mySpinner;
    int temp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_page);

        mySpinner = findViewById(R.id.spinnerId);

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.SpinnerArray,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        temp = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void GoToSubProject(View view) {
        if(temp == 1)
        {
            Intent myIntent = new Intent(this, guessingGame.class);
            startActivity(myIntent);
        }
        else if(temp == 2)
        {
            Intent myIntent = new Intent(this, Matrix_Calculator.class);
            startActivity(myIntent);
        }
        else if(temp == 3)
        {
            Intent myIntent = new Intent(this, Finance.class);
            startActivity(myIntent);
        }
        else if(temp == 4)
        {
            Intent myIntent = new Intent(this, Currency_Converter.class);
            startActivity(myIntent);
        }
        else if(temp == 5)
        {
            Intent myIntent = new Intent(this, Accounting.class);
            startActivity(myIntent);
        }
        else
        {
            Toast.makeText(this, "Please Select Any Item.", Toast.LENGTH_SHORT).show();
        }

    }
}