package com.example.oralmogproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Piece {
    protected Bitmap bitmap;

    public Piece(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void draw(Canvas canvas, int x, int y)
    {
        canvas.drawBitmap(bitmap,x,y,null);
    }
}
