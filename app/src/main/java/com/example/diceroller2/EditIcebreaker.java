package com.example.diceroller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditIcebreaker extends AppCompatActivity {
    private EditText editIceText;
    private Button btnCancel;
    private Button btnSave;
    // public static final String ICE_MESSAGE_C = "com.example.diceroller2.ICE_MESSAGE_C";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_icebreaker);

        String iceMsg = getIntent().getStringExtra(MainActivity.ICE_MESSAGE);
        editIceText = (EditText) findViewById(R.id.editIceText);
        editIceText.setText(iceMsg);

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                cancel();
            }
        });

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                save();
            }
        });

    }

    private void cancel() {
        finish();
    }

    private void save() {
        String iceStr = editIceText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("return_message", iceStr);
        setResult(RESULT_OK, intent);
        finish();
    }

    // This method will be invoked when user click android device Back menu at bottom.
    @Override
    public void onBackPressed() {
        String iceStr = editIceText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("return_message", iceStr);
        setResult(RESULT_OK, intent);
        finish();
    }
}
