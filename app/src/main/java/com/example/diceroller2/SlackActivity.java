package com.example.diceroller2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SlackActivity extends AppCompatActivity {
    private Button btnSlackShare;
    private String score;
    private TextView scoreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slack);

        score = getIntent().getStringExtra(MainActivity.SCORE);

        scoreTV = (TextView)findViewById(R.id.scoreTV);
        scoreTV.setText(score);

        btnSlackShare = (Button) findViewById(R.id.btnSlackShare);
        btnSlackShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                shareOnSlack();
            }
        });
    }

    private void shareOnSlack(){

    }
}
