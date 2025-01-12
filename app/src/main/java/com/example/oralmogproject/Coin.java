package com.example.oralmogproject;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Coin extends Shape {
    private int radius;
    private Paint p;
    private int lastX, lastY;

    public Coin(int x, int y, int color, int radius) {
        super(x, y, color);
        this.radius = radius;
        lastX = x;
        lastY = y;

        p = new Paint();
        p.setColor(color);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle(x,y,radius,p);
    }

    public int getRadius() {
        return radius;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }
}
