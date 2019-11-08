package com.example.diceroller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


        btnSlackShare = (Button) findViewById(R.id.btnSlackShare);
        btnSlackShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                shareOnSlack();
            }
        });
    }

    private void shareOnSlack(){
        Intent intent = getIntent();
        score = intent.getStringExtra(MainActivity.SCORE);
        scoreTV = (TextView)findViewById(R.id.scoreTV);
        scoreTV.setText(score);
    }

    // This method will be invoked when user click android device Back menu at bottom.
    @Override
    public void onBackPressed() {
        finish();
    }
}
