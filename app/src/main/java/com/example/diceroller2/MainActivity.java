package com.example.diceroller2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    public static final String ROLLED_NUMBER = "com.example.diceroller2.ROLLED_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Roll Dice button */
    public void rollDice(View view) {
        Intent intent = new Intent(this, DisplayButtonNumber.class);
        // Button mButton = (Button) findViewById(R.id.button);
        String rolledNumber = "6";
        intent.putExtra(ROLLED_NUMBER, rolledNumber);
        startActivity(intent);
    }
}
