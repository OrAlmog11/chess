package com.example.oralmogproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Piece {
    protected Bitmap bitmap;
    protected String color;




    protected int x;
    protected int y;



    public Piece(Bitmap bitmap, String color, int x, int y) {
        this.bitmap = bitmap;
        this.color = color;
        this.x = x;
        this.y = y;
    }


    public String getColor(){
        return this.color;
    }

    public void draw(Canvas canvas, int x, int y)
    {
        canvas.drawBitmap(bitmap,x,y,null);
    }
}
