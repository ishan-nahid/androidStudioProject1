package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class guessingGame extends AppCompatActivity {

    EditText userGuess;

    Button userGuessCheckBtn, goHome;

    int system_Number = generate();
    int attempt = 1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);

        userGuess = findViewById(R.id.guessEditText);

        userGuessCheckBtn = findViewById(R.id.guessGameBtnId);

        userGuessCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int user_number = Integer.parseInt(userGuess.getText().toString());

                if(user_number == system_Number)
                {
                    Toast.makeText(guessingGame.this, "Voila! Congratulations", Toast.LENGTH_SHORT).show();
                    Toast.makeText(guessingGame.this, "You Did it in " + attempt + "attempts", Toast.LENGTH_LONG).show();

                }
                else if(user_number > system_Number)
                {
                    attempt++;
                    Toast.makeText(guessingGame.this, "Guess a smaller number", Toast.LENGTH_LONG).show();
                }
                else
                {
                    attempt++;
                    Toast.makeText(guessingGame.this, "Guess a bigger number", Toast.LENGTH_LONG).show();
                }

            }
        });

        goHome = findViewById(R.id.guess2Home);

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(guessingGame.this, Spinner_page.class);
                startActivity(myIntent);
            }
        });

    }

    private int generate() {
        return (int)((Math.random() * (100 - 1)) + 1);
    }
}