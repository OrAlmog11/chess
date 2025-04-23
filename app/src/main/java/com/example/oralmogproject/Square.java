package com.example.oralmogproject;

import android.graphics.Canvas;
import android.graphics.Paint;


public class Square{
    private int w,h;  // w = width h = high
    private Paint p;
    int x,y, color;

    Piece piece;

    public Square(int x, int y, int w, int h, int color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;

        p = new Paint();
        p.setColor(color);
        piece = null;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }



    public void draw(Canvas canvas)
    {
        canvas.drawRect(x,y,x+w,y+h,p);
        if(piece != null)
        {
            piece.draw(canvas,x,y);
        }
    }

    public boolean didUserTouchMe(int xu, int yu) {
        return xu > x && xu < x+w && yu > y && yu < y+h;
    }


}
