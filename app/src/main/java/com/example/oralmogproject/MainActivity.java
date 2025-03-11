package com.example.oralmogproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlayOnline, btnPlayOffline;

    private ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlayOnline = findViewById(R.id.btnPlayOnline);
        btnPlayOnline.setOnClickListener(this);

        btnPlayOffline = findViewById(R.id.btnPlayOffline);
        btnPlayOffline.setOnClickListener(this);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                        }

                    }
                });
    }


    @Override
    public void onClick(View v) {
        if (v==btnPlayOffline)
        {
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("PlayerColor", "Black");
            activityResultLauncher.launch(i);
        }
        if (v==btnPlayOnline)
        {
            Intent i = new Intent(this, GameActivity.class);
            activityResultLauncher.launch(i);
        }

    }
}