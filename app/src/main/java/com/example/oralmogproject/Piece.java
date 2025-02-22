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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getColor(){
        return this.color;
    }

    public void draw(Canvas canvas, int x, int y)
    {
        canvas.drawBitmap(bitmap,x,y,null);
    }
}
