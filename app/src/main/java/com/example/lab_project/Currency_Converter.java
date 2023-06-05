package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Currency_Converter extends AppCompatActivity {

    EditText amount;

    Button Btn, goHome;

    TextView convertedMoney;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        amount = findViewById(R.id.moneyEditText);

        convertedMoney = findViewById(R.id.convertedMoneyId);

        goHome = findViewById(R.id.converter2Home);

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Currency_Converter.this, Spinner_page.class);
                startActivity(myIntent);
            }
        });

    }

    public void convertFunction(View view) {
        Btn = findViewById(view.getId());
        String s = Btn.getText().toString();

        Double money = Double.parseDouble(amount.getText().toString());

        Double Money = 0.0;
        if(s.equals("$ -> ৳"))
        {
            Money = money*106.0;
        }
        else if(s.equals("৳ -> $"))
        {
            Money = money/106.0;
        }
        else if(s.equals("€-> ৳"))
        {
            Money = money*115.42;
        }
        else if(s.equals("৳ -> €"))
        {
            Money = money/115.42;
        }
        else if(s.equals("₽-> ৳"))
        {
            Money = money*1.32;
        }
        else if(s.equals("৳ -> ₽"))
        {
            Money = money/1.32;
        }



        convertedMoney.setText(""+String.format("%.3f", Money));

    }
}