package com.example.oralmogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    FbModule fbModule;
    private BoardGame boardGame;
    private SoundPool soundPool;
    int sound1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String color = intent.getStringExtra("PlayerColor");
        Toast.makeText(this, "" + color, Toast.LENGTH_SHORT).show();

        boardGame = new BoardGame(this, color);
        setContentView(boardGame);

        fbModule = new FbModule(this);

        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC,0);

        sound1 = soundPool.load(this,R.raw.zapsplat_cartoon3,1);


    }


    private void createDialog() {
        if(!this.isFinishing())
        {
            CustomDialog customDialog = new CustomDialog(this);
            customDialog.show();
        }
    }

    public void resultToMainActivity(String color)
    {

        Intent intent = new Intent();
        intent.putExtra("ColorWin",color);
        setResult(RESULT_OK,intent);
        createDialog();
    }

    public void setMove(Move move) {
        boardGame.setMove(move);
    }

    public void setSound()
    {
        soundPool.play(sound1,1,1,0,0,1);
    }

    public void setNewMoveToFb(Move move) {
        fbModule.setPlayInFireBase(move);
    }
}