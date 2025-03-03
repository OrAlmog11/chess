package com.example.oralmogproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Pawn extends Piece{

    private boolean isFirstMove = true;
    public Pawn(Bitmap DD, String color, int x, int y) {
        super(DD,color,x,y);


    }
    public boolean getisFirstMove(){
        return this.isFirstMove;
    }
    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public void draw(Canvas canvas, int x, int y)
    {
        super.draw(canvas,x,y);
    }


}
