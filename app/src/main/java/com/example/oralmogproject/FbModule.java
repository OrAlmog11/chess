package com.example.oralmogproject;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FbModule
{
    private Context context;
    public FbModule(Context context) {
        this.context = context;

        setPlayInFireBase(null);
        initFirebaseListener();
    }

    private void initFirebaseListener() {
        // הפונקציה יוצרת מאזין ב FireBase
        //
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("play");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Move move = snapshot.getValue(Move.class);
                //Toast.makeText(context, "onDataChange " + play, Toast.LENGTH_SHORT).show();
                if(move != null){
                    (BoardGame(context)).setMove(move);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void setPlayInFireBase(Move move) {
        // write to Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("play");
        reference.setValue(move);
    }
}
