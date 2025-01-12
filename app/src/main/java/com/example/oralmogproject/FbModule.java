package com.example.oralmogproject;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FbModule {

    FirebaseDatabase database;
    Context context;

    ArrayList<Board> Board;

    public FbModule(Context context, ArrayList<Ball> balls)
    {
        database = FirebaseDatabase.getInstance();
        this.context = context;
        this.balls = balls;

        DatabaseReference reference = database.getReference("balls");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                balls.clear();
                for (DataSnapshot userSnapshot : snapshot.getChildren())
                {
                    Ball currentBall = userSnapshot.getValue(Ball.class);
                    balls.add(currentBall);
                }
                ((MainActivity)context).dataChange();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void setBall(int x, int y, int r, int color)
    {
        Ball ball = new Ball(x,y,r,color);

        DatabaseReference myRef = database.getReference("balls").push();
        myRef.setValue(ball);
    }
}
