package com.example.oralmogproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class King extends Piece{

    private int x;
    private int y;
    public King(Bitmap DD, String color, int x, int y) {
        super(DD,color,x,y);


    }

    public void draw(Canvas canvas, int x, int y)
    {
        super.draw(canvas,x,y);
    }


}
