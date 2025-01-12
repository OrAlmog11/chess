package com.example.oralmogproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class BoardGame extends View {
    private Context context;
    private Square[][] squares;
    private Coin coin;
    private final int a = 1, b = 2, c = 3, d = 4, e = 5, f = 6, g = 7, h = 8;

    private final int NUM_OF_SQUARES = 8;

    private Bitmap bitmap;
    private boolean firstTime = true;



    public BoardGame(Context context) {
        super(context);

        squares = new Square[NUM_OF_SQUARES][NUM_OF_SQUARES];



    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if(firstTime)
        {
            initBoard(canvas);
            initCoin(canvas);
            initPieces(canvas);
            firstTime = false;
        }

        drawBoard(canvas);
        //drawCoin(canvas);


    }

    private void initPieces(Canvas canvas) {
        int w = canvas.getWidth()/NUM_OF_SQUARES;
        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.white_pawn);
        b = Bitmap.createScaledBitmap(b,w,w,true);
        Pawn p = new Pawn(b,"White");
        squares[1][0].setPiece(p);
        squares[1][1].setPiece(p);
        squares[1][2].setPiece(p);
        squares[1][3].setPiece(p);
        squares[1][4].setPiece(p);
        squares[1][5].setPiece(p);
        squares[1][6].setPiece(p);
        squares[1][7].setPiece(p);
        Bitmap c = BitmapFactory.decodeResource(getResources(),R.drawable.black_pawn);
        c = Bitmap.createScaledBitmap(c,w,w,true);
        Pawn p2 = new Pawn(c,"Black");
        squares[6][0].setPiece(p2);
        squares[6][1].setPiece(p2);
        squares[6][2].setPiece(p2);
        squares[6][3].setPiece(p2);
        squares[6][4].setPiece(p2);
        squares[6][5].setPiece(p2);
        squares[6][6].setPiece(p2);
        squares[6][7].setPiece(p2);

    }

    private void drawCoin(Canvas canvas) {
        coin.draw(canvas);
    }

    private void initCoin(Canvas canvas) {
        int w = canvas.getWidth()/NUM_OF_SQUARES;
        coin = new Coin(w/2,w/2,Color.RED,w/4);
    }

    private void drawBoard(Canvas canvas) {
        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares.length; j++)
            {
                squares[i][j].draw(canvas);
            }
        }
    }

    private void initBoard(Canvas canvas) {
        int x = 0;
        int y = 0;
        int w = canvas.getWidth()/NUM_OF_SQUARES;
        int h = w;
        int color;

        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < NUM_OF_SQUARES; j++)
            {
                if(i%2 == 0)  // Even lines  שורות זוגיות
                {
                    if(j%2 == 0)
                        color = Color.WHITE;
                    else
                        color = Color.BLACK;
                    
                }
                else
                {   // Odd lines   שורות אי זוגיות
                    if(j%2 == 0)
                        color = Color.BLACK;
                    else
                        color = Color.WHITE;
                }
                squares[i][j] = new Square(x,y,w,h,color);
                x = x+w;
            }
            x = 0;
            y = y + h;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {

        }
        if(event.getAction() == MotionEvent.ACTION_MOVE)
        {
            coin.x = (int) event.getX();
            coin.y = (int) event.getY();
            invalidate();
        }
        if(event.getAction() == MotionEvent.ACTION_UP)
        {
            coin.x = (int)event.getX();
            coin.y = (int)event.getY();
            updateCoinAfterRelease();
            invalidate();
        }


        return true;
    }

    private void updateCoinAfterRelease() {
        int x1 = 0, y1 = 0; //
        for (int i = 0; i < NUM_OF_SQUARES; i++) {
            for (int j = 0; j < NUM_OF_SQUARES; j++) {
                if(squares[i][j].didUserTouchMe(coin.x, coin.y))
                {
                    x1 = i;
                    y1 = j;
                }
            }
        }

        if(squares[x1][y1].color == Color.BLACK)
        {
            coin.x = squares[x1][y1].x + coin.getRadius() * 2;
            coin.y = squares[x1][y1].y + coin.getRadius() * 2;
            coin.setLastX(coin.x);
            coin.setLastY(coin.y);
        }
        else
        {
            coin.x = coin.getLastX();
            coin.y = coin.getLastY();
        }

    }
}
