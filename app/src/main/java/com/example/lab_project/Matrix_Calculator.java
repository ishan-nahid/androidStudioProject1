package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Matrix_Calculator extends AppCompatActivity {

    Button plus, minus, multi, goHome;

    EditText aID, bID, cID, dID, eID, fID, gID, hID;

    TextView AID, BID, CID, DID;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_calculator);

        plus = findViewById(R.id.additionBtnId);
        minus = findViewById(R.id.substractionBtnId);
        multi = findViewById(R.id.multiplicationBtnId);

        aID = findViewById(R.id.aId);
        bID = findViewById(R.id.bId);
        cID = findViewById(R.id.cId);
        dID = findViewById(R.id.dId);
        eID = findViewById(R.id.eId);
        fID = findViewById(R.id.fId);
        gID = findViewById(R.id.gId);
        hID = findViewById(R.id.hId);

        AID = findViewById(R.id.AId);
        BID = findViewById(R.id.BId);
        CID = findViewById(R.id.CId);
        DID = findViewById(R.id.DId);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a, b, c, d, e, f, g, h;
                a = Integer.parseInt(aID.getText().toString());
                b = Integer.parseInt(bID.getText().toString());
                c = Integer.parseInt(cID.getText().toString());
                d = Integer.parseInt(dID.getText().toString());
                e = Integer.parseInt(eID.getText().toString());
                f = Integer.parseInt(fID.getText().toString());
                g = Integer.parseInt(gID.getText().toString());
                h = Integer.parseInt(hID.getText().toString());

                AID.setText(""+(a+e));

                BID.setText(""+(b+f));

                CID.setText(""+(c+g));

                DID.setText(""+(d+h));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a, b, c, d, e, f, g, h;
                a = Integer.parseInt(aID.getText().toString());
                b = Integer.parseInt(bID.getText().toString());
                c = Integer.parseInt(cID.getText().toString());
                d = Integer.parseInt(dID.getText().toString());
                e = Integer.parseInt(eID.getText().toString());
                f = Integer.parseInt(fID.getText().toString());
                g = Integer.parseInt(gID.getText().toString());
                h = Integer.parseInt(hID.getText().toString());

                AID.setText(""+(a-e));

                BID.setText(""+(b-f));

                CID.setText(""+(c-g));

                DID.setText(""+(d-h));
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a, b, c, d, e, f, g, h;

                a = Integer.parseInt(aID.getText().toString());
                b = Integer.parseInt(bID.getText().toString());
                c = Integer.parseInt(cID.getText().toString());
                d = Integer.parseInt(dID.getText().toString());
                e = Integer.parseInt(eID.getText().toString());
                f = Integer.parseInt(fID.getText().toString());
                g = Integer.parseInt(gID.getText().toString());
                h = Integer.parseInt(hID.getText().toString());

                AID.setText(""+(a*e+b*g));
                BID.setText(""+(a*f+b*h));
                CID.setText(""+(c*e+d*g));
                DID.setText(""+(c*f+d*h));
            }
        });

        goHome = findViewById(R.id.matrix2Home);

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Matrix_Calculator.this, Spinner_page.class);
                startActivity(myIntent);
            }
        });

    }
}