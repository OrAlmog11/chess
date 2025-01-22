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
        Pawn wp1 = new Pawn(wp,"White",squares[1][0].getX(),squares[1][0].getY());
        Pawn wp2 = new Pawn(wp,"White",squares[1][1].getX(),squares[1][1].getY());
        Pawn wp3 = new Pawn(wp,"White",squares[1][2].getX(),squares[1][2].getY());
        Pawn wp4 = new Pawn(wp,"White",squares[1][3].getX(),squares[1][3].getY());
        Pawn wp5 = new Pawn(wp,"White",squares[1][4].getX(),squares[1][4].getY());
        Pawn wp6 = new Pawn(wp,"White",squares[1][5].getX(),squares[1][5].getY());
        Pawn wp7 = new Pawn(wp,"White",squares[1][6].getX(),squares[1][6].getY());
        Pawn wp8 = new Pawn(wp,"White",squares[1][7].getX(),squares[1][7].getY());
        squares[1][0].setPiece(wp1);
        squares[1][1].setPiece(wp2);
        squares[1][2].setPiece(wp3);
        squares[1][3].setPiece(wp4);
        squares[1][4].setPiece(wp5);
        squares[1][5].setPiece(wp6);
        squares[1][6].setPiece(wp7);
        squares[1][7].setPiece(wp8);
        Bitmap bp = BitmapFactory.decodeResource(getResources(),R.drawable.black_pawn);
        bp = Bitmap.createScaledBitmap(bp,w,w,true);
        Pawn bp1 = new Pawn(bp,"Black",squares[6][0].getX(),squares[6][0].getY());
        Pawn bp2 = new Pawn(bp,"Black",squares[6][1].getX(),squares[6][1].getY());
        Pawn bp3 = new Pawn(bp,"Black",squares[6][2].getX(),squares[6][2].getY());
        Pawn bp4 = new Pawn(bp,"Black",squares[6][3].getX(),squares[6][3].getY());
        Pawn bp5 = new Pawn(bp,"Black",squares[6][4].getX(),squares[6][4].getY());
        Pawn bp6 = new Pawn(bp,"Black",squares[6][5].getX(),squares[6][5].getY());
        Pawn bp7 = new Pawn(bp,"Black",squares[6][6].getX(),squares[6][6].getY());
        Pawn bp8 = new Pawn(bp,"Black",squares[6][7].getX(),squares[6][7].getY());
        squares[6][0].setPiece(bp1);
        squares[6][1].setPiece(bp2);
        squares[6][2].setPiece(bp3);
        squares[6][3].setPiece(bp4);
        squares[6][4].setPiece(bp5);
        squares[6][5].setPiece(bp6);
        squares[6][6].setPiece(bp7);
        squares[6][7].setPiece(bp8);
        Bitmap wr = BitmapFactory.decodeResource(getResources(),R.drawable.white_rook);
        wr = Bitmap.createScaledBitmap(wr,w,w,true);
        Rook wr1 = new Rook(wr,"White",squares[0][0].getX(),squares[0][0].getY());
        Rook wr2 = new Rook(wr,"White",squares[0][7].getX(),squares[0][7].getY());
        squares[0][0].setPiece(wr1);
        squares[0][7].setPiece(wr2);
        Bitmap br = BitmapFactory.decodeResource(getResources(),R.drawable.black_rook);
        br = Bitmap.createScaledBitmap(br,w,w,true);
        Rook br1 = new Rook(br,"Black",squares[7][0].getX(),squares[7][0].getY());
        Rook br2 = new Rook(br,"Black",squares[7][7].getX(),squares[7][7].getY());
        squares[7][0].setPiece(br1);
        squares[7][7].setPiece(br2);
        Bitmap wk = BitmapFactory.decodeResource(getResources(),R.drawable.white_king);
        wk = Bitmap.createScaledBitmap(wk,w,w,true);
        King Wk = new King(wk,"White",squares[0][3].getX(),squares[0][3].getY());
        squares[0][3].setPiece(Wk);
        Bitmap bk = BitmapFactory.decodeResource(getResources(),R.drawable.black_king);
        bk = Bitmap.createScaledBitmap(bk,w,w,true);
        King Bk = new King(bk,"Black",squares[7][3].getX(),squares[7][3].getY());
        squares[7][3].setPiece(Bk);
        Bitmap wq = BitmapFactory.decodeResource(getResources(),R.drawable.white_queen);
        wq = Bitmap.createScaledBitmap(wq,w,w,true);
        Queen Wq = new Queen(wq,"White",squares[0][4].getX(),squares[0][4].getY());
        squares[0][4].setPiece(Wq);
        Bitmap bq = BitmapFactory.decodeResource(getResources(),R.drawable.black_queen);
        bq = Bitmap.createScaledBitmap(bq,w,w,true);
        Queen Bq = new Queen(bq,"Black",squares[7][4].getX(),squares[7][4].getY());
        squares[7][4].setPiece(Bq);
        Bitmap wk2 = BitmapFactory.decodeResource(getResources(),R.drawable.white_knight);//white knight = wk2
        wk2 = Bitmap.createScaledBitmap(wk2,w,w,true);
        Knight wkn1 = new Knight(wk2,"White",squares[0][1].getX(),squares[0][1].getY());
        Knight wkn2 = new Knight(wk2,"White",squares[0][6].getX(),squares[0][6].getY());
        squares[0][1].setPiece(wkn1);
        squares[0][6].setPiece(wkn2);
        Bitmap bk2 = BitmapFactory.decodeResource(getResources(),R.drawable.black_knight);//black knight = bk2
        bk2 = Bitmap.createScaledBitmap(bk2,w,w,true);
        Knight bkn1 = new Knight(bk2,"Black",squares[7][1].getX(),squares[7][1].getY());
        Knight bkn2 = new Knight(bk2,"Black",squares[7][6].getX(),squares[7][6].getY());
        squares[7][1].setPiece(bkn1);
        squares[7][6].setPiece(bkn2);
        Bitmap wb = BitmapFactory.decodeResource(getResources(),R.drawable.white_bishop);//black knight = bk2
        wb = Bitmap.createScaledBitmap(wb,w,w,true);
        Bishop wb1 = new Bishop(wb,"White",squares[0][2].getX(),squares[0][2].getY());
        Bishop wb2 = new Bishop(wb,"White", squares[0][5].getX(), squares[0][5].getY());
        squares[0][2].setPiece(wb1);
        squares[0][5].setPiece(wb2);
        Bitmap bb = BitmapFactory.decodeResource(getResources(),R.drawable.black_bishop);//black knight = bk2
        bb = Bitmap.createScaledBitmap(bb,w,w,true);
        Bishop bb1 = new Bishop(bb,"Black",squares[7][2].getX(),squares[7][2].getY());
        Bishop bb2 = new Bishop(bb,"Black",squares[7][5].getX(),squares[7][5].getY());
        squares[7][2].setPiece(bb1);
        squares[7][5].setPiece(bb2);



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
