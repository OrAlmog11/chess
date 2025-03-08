package com.example.oralmogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        BoardGame boardGame = new BoardGame(this);
        setContentView(boardGame);

    }
//    protected static void restartGame(Context context){
//        BoardGame boardGame = new BoardGame(context);
//    }
}