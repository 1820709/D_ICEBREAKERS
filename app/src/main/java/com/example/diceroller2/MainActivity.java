package com.example.diceroller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
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
    private TextView iceTxt;
    private TextView scoreCount;
    private int guessCount = 0;
    private Button btnIce1;
    private Button btnIce2;
    private Button btnFinish;
    private String[] iceList;
    private int rolledNumber = 0;
    private String iceStr;
    String guessCountStr;
    //private Intent intent;
    private final static int REQUEST_CODE_1 = 1;

    public static final String ICE_MESSAGE = "com.example.diceroller2.ICE_MESSAGE";
    public static final String SCORE = "com.example.diceroller2.SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        congratsTxt = (TextView)findViewById(R.id.congratsTxt);
        scoreCount = (TextView)findViewById(R.id.scoreCount);
        iceTxt = (TextView)findViewById(R.id.iceTxt);

        Resources res = getResources();
        iceList = res.getStringArray(R.array.iceList);

        imageViewDice = (ImageView) findViewById(R.id.image_view_dice);
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll_the_dice();
            }}
        );

        btnIce1 = (Button) findViewById(R.id.btnIce1);
        btnIce1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                roll_the_dice();
            }
        });

    }

    public void finish(View view) {
        Intent intent = new Intent(this, SlackActivity.class);
        intent.putExtra(SCORE, guessCountStr);
        startActivity(intent);
    }

    public void editIceBreaker(View view) {
        if (rolledNumber > 0) {
            Intent intent = new Intent(this, EditIcebreaker.class);
            String iceMessage = iceTxt.getText().toString();
            intent.putExtra(ICE_MESSAGE, iceMessage);
            startActivityForResult(intent, REQUEST_CODE_1);
        } else {
            congratsTxt.setText("Press I'm feeling lucky or Let's play D-ICEBREAKER button first!");
        }
    }

    // This method is invoked when target activity return result data back.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);

        // The returned result data is identified by requestCode.
        // The request code is specified in startActivityForResult(intent, REQUEST_CODE_1); method.
        switch (requestCode)
        {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case REQUEST_CODE_1:
                //TextView textView = (TextView)findViewById(R.id.resultDataTextView);
                if(resultCode == RESULT_OK)
                {
                    String messageReturn = dataIntent.getStringExtra("return_message");
                    iceTxt.setText(messageReturn);
                }
        }
    }

    /** Called when the user taps the Roll Dice button */
    private void roll_the_dice() {
        // clear congratsTxt
        congratsTxt.setText("");
        rolledNumber = rnd.nextInt(6) + 1;
        switch (rolledNumber){
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
        compareToGuess(rolledNumber);
        showIceBreaker(rolledNumber);
    }

    private void compareToGuess(int rolledNumber){
        int entryNumber = getEntryNumber();
        boolean isValid = validateEntryNumber(entryNumber);
        //TextView textViewCongrat = (TextView)findViewById(R.id.congratsTxt);
        if (isValid) {
            if (entryNumber == rolledNumber){
                congratsTxt.setText("Congratulations!");
                // increase score
                guessCount++;
                guessCountStr = Integer.toString(guessCount);
                scoreCount.setText(guessCountStr);
            }
        }
        else {
            congratsTxt.setText("Invalid number entered. Valid range is 1-6");
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

    private void showIceBreaker(int rolledNumber){
        iceStr = iceList[rolledNumber-1];
        iceTxt.setText(iceStr);
    }

}



