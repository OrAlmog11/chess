package com.example.oralmogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String color = intent.getStringExtra("PlayerColor");
        Toast.makeText(this, "" + color, Toast.LENGTH_SHORT).show();

        //setContentView(R.layout.activity_main);
        BoardGame boardGame = new BoardGame(this);
        setContentView(boardGame);

    }


    public void resultToMainActivity()
    {
        Intent intent = new Intent();
        intent.putExtra("ColorWin","Black");
        setResult(RESULT_OK,intent);
        finish();
    }
}