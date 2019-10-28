package com.example.diceroller2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;



public class MainActivity extends AppCompatActivity {
    private ImageView imageViewDice;
    private Random rnd = new Random();
    private EditText editText;
    private TextView textView;
    private TextView congratsTxt;
    private int guessCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewDice = findViewById(R.id.image_view_dice);
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }}
        );
    }

    /** Called when the user taps the Roll Dice button */
    private void rollDice() {
        // clear congratsTxt
        TextView textViewCongrat = (TextView)findViewById(R.id.congratsTxt);
        textViewCongrat.setText("");
        int randomNumber = rnd.nextInt(6) + 1;
        switch (randomNumber){
            case 1:
                imageViewDice.setImageResource(R.drawable.die1);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.die2);
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.die3);
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.die4);
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.die5);
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.die6);
                break;
        }

        compareToGuess(randomNumber);
    }

    private void compareToGuess(int rolledNumber){
        int entryNumber = getEntryNumber();
        boolean isValid = validateEntryNumber(entryNumber);
        TextView textViewCongrat = (TextView)findViewById(R.id.congratsTxt);
        if (isValid) {
            if (entryNumber == rolledNumber){
                // put conrats in congratsTxt
                textViewCongrat.setText("Congratulations!");
                // increse score by one
                guessCount += 1;
                String guessCountStr = Integer.toString(guessCount);
                TextView textViewScore = (TextView)findViewById(R.id.scoreCount);
                textViewScore.setText(guessCountStr);
            }
        }
        else {
            // put invalid number in congratsTxt
            textViewCongrat.setText("Invalid number entered. Valid range is 1-6");
        }

    }

    private int getEntryNumber() {
        editText = (EditText) findViewById(R.id.editText);
        String guessRolledStr = editText.getText().toString();
        try {
            int guessRolledInt = Integer.parseInt(guessRolledStr);
            return guessRolledInt;
        } catch (NumberFormatException ex)
        {
            return -1;
        }

    }

    private boolean validateEntryNumber(int guessNumber){
        if (1 <= guessNumber && guessNumber <= 6) {
            return true;
        }
        return false;
    }
}
