package com.example.oralmogproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;


public class BoardGame extends View {
    private Context context;
    private Square[][] squares;
    private Coin coin;
    private final int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7;

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
            initPieces(canvas);
            firstTime = false;
        }

        drawBoard(canvas);
        //drawCoin(canvas);


    }

    private void initPieces(Canvas canvas) {
        int w = canvas.getWidth()/NUM_OF_SQUARES;
        Bitmap wp = BitmapFactory.decodeResource(getResources(),R.drawable.white_pawn);
        wp = Bitmap.createScaledBitmap(wp,w,w,true);
        Pawn p = new Pawn(wp,"White");
        squares[1][0].setPiece(p);
        squares[1][1].setPiece(p);
        squares[1][2].setPiece(p);
        squares[1][3].setPiece(p);
        squares[1][4].setPiece(p);
        squares[1][5].setPiece(p);
        squares[1][6].setPiece(p);
        squares[1][7].setPiece(p);
        Bitmap bp = BitmapFactory.decodeResource(getResources(),R.drawable.black_pawn);
        bp = Bitmap.createScaledBitmap(bp,w,w,true);
        Pawn p2 = new Pawn(bp,"Black");
        squares[6][0].setPiece(p2);
        squares[6][1].setPiece(p2);
        squares[6][2].setPiece(p2);
        squares[6][3].setPiece(p2);
        squares[6][4].setPiece(p2);
        squares[6][5].setPiece(p2);
        squares[6][6].setPiece(p2);
        squares[6][7].setPiece(p2);
        Bitmap wr = BitmapFactory.decodeResource(getResources(),R.drawable.white_rook);
        wr = Bitmap.createScaledBitmap(wr,w,w,true);
        Rook r = new Rook(wr,"White");
        squares[0][0].setPiece(r);
        squares[0][7].setPiece(r);
        Bitmap br = BitmapFactory.decodeResource(getResources(),R.drawable.black_rook);
        br = Bitmap.createScaledBitmap(br,w,w,true);
        Rook r2 = new Rook(br,"Black");
        squares[7][0].setPiece(r2);
        squares[7][7].setPiece(r2);
        Bitmap wk = BitmapFactory.decodeResource(getResources(),R.drawable.white_king);
        wk = Bitmap.createScaledBitmap(wk,w,w,true);
        King k = new King(wk,"White");
        squares[0][3].setPiece(k);
        Bitmap bk = BitmapFactory.decodeResource(getResources(),R.drawable.black_king);
        bk = Bitmap.createScaledBitmap(bk,w,w,true);
        King k2 = new King(bk,"Black");
        squares[7][3].setPiece(k2);
        Bitmap wq = BitmapFactory.decodeResource(getResources(),R.drawable.white_queen);
        wq = Bitmap.createScaledBitmap(wq,w,w,true);
        Queen q = new Queen(wq,"White");
        squares[0][4].setPiece(q);
        Bitmap bq = BitmapFactory.decodeResource(getResources(),R.drawable.black_queen);
        bq = Bitmap.createScaledBitmap(bq,w,w,true);
        Queen q2 = new Queen(bq,"Black");
        squares[7][4].setPiece(q2);
        Bitmap wk2 = BitmapFactory.decodeResource(getResources(),R.drawable.white_knight);//white knight = wk2
        wk2 = Bitmap.createScaledBitmap(wk2,w,w,true);
        Knight kn = new Knight(wk2,"White");
        squares[0][1].setPiece(kn);
        squares[0][6].setPiece(kn);
        Bitmap bk2 = BitmapFactory.decodeResource(getResources(),R.drawable.black_knight);//black knight = bk2
        bk2 = Bitmap.createScaledBitmap(bk2,w,w,true);
        Knight kn2 = new Knight(bk2,"Black");
        squares[7][1].setPiece(kn2);
        squares[7][6].setPiece(kn2);
        Bitmap wb = BitmapFactory.decodeResource(getResources(),R.drawable.white_bishop);//black knight = bk2
        wb = Bitmap.createScaledBitmap(wb,w,w,true);
        Bishop b = new Bishop(wb,"White");
        squares[0][2].setPiece(b);
        squares[0][5].setPiece(b);
        Bitmap bb = BitmapFactory.decodeResource(getResources(),R.drawable.black_bishop);//black knight = bk2
        bb = Bitmap.createScaledBitmap(bb,w,w,true);
        Bishop b2 = new Bishop(bb,"Black");
        squares[7][2].setPiece(b2);
        squares[7][5].setPiece(b2);



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
                        color = Color.GRAY;
                    
                }
                else
                {   // Odd lines   שורות אי זוגיות
                    if(j%2 == 0)
                        color = Color.GRAY;
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
