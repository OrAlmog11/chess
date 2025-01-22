package com.example.oralmogproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Rook extends Piece{

    private int x;
    private int y;
    public Rook(Bitmap bb, String color, int x, int y) {
        super(bb,color);
        this.x = x;
        this.y = y;

    }

    public void draw(Canvas canvas, int x, int y)
    {
        super.draw(canvas,x,y);
    }


}
