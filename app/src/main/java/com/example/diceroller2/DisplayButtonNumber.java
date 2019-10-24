package com.example.diceroller2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import java.util.Random;

public class DisplayButtonNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_button_number);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String rolledNumber = intent.getStringExtra(MainActivity.ROLLED_NUMBER);

        // Capture the layout's text view field and set the rolled number as its text
        TextView textView = findViewById(R.id.textView2);
        // Generate rundom number between 1 to 6 and isplay ir below
        // int random = 1 + Random.nextInt(6)
        // TO DO need to fix below
        textView.setText(rolledNumber);
    }
}
