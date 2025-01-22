package com.example.oralmogproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Pawn extends Piece{

    private int x;
    private int y;
    public Pawn(Bitmap b, String color, int x, int y) {
        super(b, color);
        this.x = x;
        this.y = y;

    }

    public void draw(Canvas canvas, int x, int y)
    {
        super.draw(canvas,x,y);
    }


}
