package com.example.oralmogproject;

import android.graphics.Canvas;
import android.graphics.Paint;


public class Square extends Shape{
    private int w,h;  // w = width h = high
    private Paint p;

    Piece piece;

    public Square(int x, int y, int w, int h, int color) {
        super(x, y, color);
        this.w = w;
        this.h = h;

        p = new Paint();
        p.setColor(color);
        piece = null;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String takenByColor(){
        if (this.piece == null)
            return null;
        else
            return this.piece.getColor();

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

    public void addPiece(Pawn p1) {
        this.piece = p1;
    }
}
