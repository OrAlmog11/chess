package com.example.oralmogproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Piece {
    protected Bitmap bitmap;

    public Piece(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap,0,0,null);
    }
}
