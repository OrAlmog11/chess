package com.example.oralmogproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Knight extends Piece{

    private int x;
    private int y;
    public Knight(Bitmap DD, String color, int x, int y) {
        super(DD,color);
        this.x = x;
        this.y = y;

    }

    public void draw(Canvas canvas, int x, int y)
    {
        super.draw(canvas,x,y);
    }


}
