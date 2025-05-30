package com.example.oralmogproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlayOnlineWhite, btnPlayOnlineBlack, btnPlayOffline;
    private String colorwon = "None";
    private int white_win_count = 0;
    private int black_win_count = 0;

    private ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlayOnlineWhite = findViewById(R.id.btnPlayOnlineWhite);
        btnPlayOnlineWhite.setOnClickListener(this);

        btnPlayOnlineBlack = findViewById(R.id.btnPlayOnlineBlack);
        btnPlayOnlineBlack.setOnClickListener(this);

        btnPlayOffline = findViewById(R.id.btnPlayOffline);
        btnPlayOffline.setOnClickListener(this);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            colorwon = data.getStringExtra("ColorWin");

                        }
                        if(colorwon.equals("White")){
                            white_win_count++;
                            Toast.makeText(MainActivity.this, "White won! White have " + white_win_count + " wins!", Toast.LENGTH_SHORT).show();
                        }
                        else if(colorwon.equals("Black")){
                            black_win_count++;
                            Toast.makeText(MainActivity.this, "Black won! Black have " + black_win_count + " wins!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }




    @Override
    public void onClick(View v) {
        if (v==btnPlayOnlineBlack)
        {
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("PlayerColor", "Black");
            activityResultLauncher.launch(i);
        }
        if (v==btnPlayOnlineWhite)
        {
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("PlayerColor", "White");
            activityResultLauncher.launch(i);
        }

        if (v==btnPlayOffline)
        {
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("PlayerColor", "Offline");
            activityResultLauncher.launch(i);
        }

    }
}