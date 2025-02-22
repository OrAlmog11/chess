package com.example.oralmogproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Pawn extends Piece{

    private int x;
    private int y;
    private boolean isFirstMove;
    public Pawn(Bitmap b, String color, int x, int y, boolean isFirstMove) {
        super(b, color,x,y);
        this.isFirstMove = true;

    }
    public boolean getisFirstMove(){
        return this.isFirstMove;
    }

    public void draw(Canvas canvas, int x, int y)
    {
        super.draw(canvas,x,y);
    }


}
