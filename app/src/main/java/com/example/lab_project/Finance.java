package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Finance extends AppCompatActivity {

    EditText roomRent, houseBill, foodBill;

    TextView billID;

    Button insertBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

        billID = findViewById(R.id.billingId);

        roomRent = findViewById(R.id.roomRentId);
        houseBill = findViewById(R.id.houseBillId);
        foodBill = findViewById(R.id.foodBillId);

        insertBtn = findViewById(R.id.financeInsertId);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Id = billID.getText().toString();
                String room = roomRent.getText().toString();
                String household = houseBill.getText().toString();
                String food = foodBill.getText().toString();

                int total = Integer.parseInt(room)+Integer.parseInt(household)+Integer.parseInt(food);

                String Total = String.valueOf(total);

                bills bill = new bills(room, household, food, Total);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference root = db.getReference("Expense");

                root.child(Id).setValue(bill);

                Toast.makeText(Finance.this, "Successfully Updated to Server", Toast.LENGTH_SHORT).show();

                roomRent.setText("");
                houseBill.setText("");
                foodBill.setText("");
            }
        });


    }
}