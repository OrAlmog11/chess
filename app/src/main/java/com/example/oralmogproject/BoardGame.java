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
    private String turn = "White";
    private String  turncolor;
    private Square[][] squares;
    private int currX, currY, x1, y1, x2, y2;
    private Piece tempPiece;
    private Pawn tempPawn;// בעל תכונות נפרדות מpieces ולכן יוצר עצם משל עצמו על מנת לגשת אל התכונות


    private Rook tempRook; // בעל תכונות נפרדות מpieces ולכן יוצר עצם משל עצמו על מנת לגשת אל התכונות


    private King tempKing; // בעל תכונות נפרדות מpieces ולכן יוצר עצם משל עצמו על מנת לגשת אל התכונות


    private final int NUM_OF_SQUARES = 8;

    private boolean firstTime = true;
    private int w, h;


    public BoardGame(Context context, String color) {
        super(context);
        squares = new Square[NUM_OF_SQUARES][NUM_OF_SQUARES];
        this.context = context;
        turncolor = color;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (firstTime) {
            initBoard(canvas);
            initPieces(canvas);
            firstTime = false;
        }
        drawBoard(canvas);
    }

    private void initPieces(Canvas canvas) { // כאשר קוראים לפעולה, יוצר את החיילים, ושם את החיילים על הלוח
        int w = canvas.getWidth() / NUM_OF_SQUARES;
        Bitmap wp = BitmapFactory.decodeResource(getResources(), R.drawable.white_pawn); // פיון לבן
        wp = Bitmap.createScaledBitmap(wp, w, w, true);
        Pawn wp1 = new Pawn(wp, "White", squares[1][0].getX(), squares[1][0].getY());
        Pawn wp2 = new Pawn(wp, "White", squares[1][1].getX(), squares[1][1].getY());
        Pawn wp3 = new Pawn(wp, "White", squares[1][2].getX(), squares[1][2].getY());
        Pawn wp4 = new Pawn(wp, "White", squares[1][3].getX(), squares[1][3].getY());
        Pawn wp5 = new Pawn(wp, "White", squares[1][4].getX(), squares[1][4].getY());
        Pawn wp6 = new Pawn(wp, "White", squares[1][5].getX(), squares[1][5].getY());
        Pawn wp7 = new Pawn(wp, "White", squares[1][6].getX(), squares[1][6].getY());
        Pawn wp8 = new Pawn(wp, "White", squares[1][7].getX(), squares[1][7].getY());
        squares[1][0].setPiece(wp1);
        squares[1][1].setPiece(wp2);
        squares[1][2].setPiece(wp3);
        squares[1][3].setPiece(wp4);
        squares[1][4].setPiece(wp5);
        squares[1][5].setPiece(wp6);
        squares[1][6].setPiece(wp7);
        squares[1][7].setPiece(wp8);
        Bitmap bp = BitmapFactory.decodeResource(getResources(), R.drawable.black_pawn); // פיון שחור
        bp = Bitmap.createScaledBitmap(bp, w, w, true);
        Pawn bp1 = new Pawn(bp, "Black", squares[6][0].getX(), squares[6][0].getY());
        Pawn bp2 = new Pawn(bp, "Black", squares[6][1].getX(), squares[6][1].getY());
        Pawn bp3 = new Pawn(bp, "Black", squares[6][2].getX(), squares[6][2].getY());
        Pawn bp4 = new Pawn(bp, "Black", squares[6][3].getX(), squares[6][3].getY());
        Pawn bp5 = new Pawn(bp, "Black", squares[6][4].getX(), squares[6][4].getY());
        Pawn bp6 = new Pawn(bp, "Black", squares[6][5].getX(), squares[6][5].getY());
        Pawn bp7 = new Pawn(bp, "Black", squares[6][6].getX(), squares[6][6].getY());
        Pawn bp8 = new Pawn(bp, "Black", squares[6][7].getX(), squares[6][7].getY());
        squares[6][0].setPiece(bp1);
        squares[6][1].setPiece(bp2);
        squares[6][2].setPiece(bp3);
        squares[6][3].setPiece(bp4);
        squares[6][4].setPiece(bp5);
        squares[6][5].setPiece(bp6);
        squares[6][6].setPiece(bp7);
        squares[6][7].setPiece(bp8);
        Bitmap wr = BitmapFactory.decodeResource(getResources(), R.drawable.white_rook); // צריח לבן
        wr = Bitmap.createScaledBitmap(wr, w, w, true);
        Rook wr1 = new Rook(wr, "White", squares[0][0].getX(), squares[0][0].getY());
        Rook wr2 = new Rook(wr, "White", squares[0][7].getX(), squares[0][7].getY());
        squares[0][0].setPiece(wr1);
        squares[0][7].setPiece(wr2);
        Bitmap br = BitmapFactory.decodeResource(getResources(), R.drawable.black_rook); // צריח שחור
        br = Bitmap.createScaledBitmap(br, w, w, true);
        Rook br1 = new Rook(br, "Black", squares[7][0].getX(), squares[7][0].getY());
        Rook br2 = new Rook(br, "Black", squares[7][7].getX(), squares[7][7].getY());
        squares[7][0].setPiece(br1);
        squares[7][7].setPiece(br2);
        Bitmap wk = BitmapFactory.decodeResource(getResources(), R.drawable.white_king); // מלך לבן
        wk = Bitmap.createScaledBitmap(wk, w, w, true);
        King Wk = new King(wk, "White", squares[0][3].getX(), squares[0][3].getY());
        squares[0][3].setPiece(Wk);
        Bitmap bk = BitmapFactory.decodeResource(getResources(), R.drawable.black_king); // מלך שחור
        bk = Bitmap.createScaledBitmap(bk, w, w, true);
        King Bk = new King(bk, "Black", squares[7][3].getX(), squares[7][3].getY());
        squares[7][3].setPiece(Bk);
        Bitmap wq = BitmapFactory.decodeResource(getResources(), R.drawable.white_queen); // מלכה לבנה
        wq = Bitmap.createScaledBitmap(wq, w, w, true);
        Queen Wq = new Queen(wq, "White", squares[0][4].getX(), squares[0][4].getY());
        squares[0][4].setPiece(Wq);
        Bitmap bq = BitmapFactory.decodeResource(getResources(), R.drawable.black_queen); // מלכה שחורה
        bq = Bitmap.createScaledBitmap(bq, w, w, true);
        Queen Bq = new Queen(bq, "Black", squares[7][4].getX(), squares[7][4].getY());
        squares[7][4].setPiece(Bq);
        Bitmap wk2 = BitmapFactory.decodeResource(getResources(), R.drawable.white_knight); // פרש לבן
        wk2 = Bitmap.createScaledBitmap(wk2, w, w, true);
        Knight wkn1 = new Knight(wk2, "White", squares[0][1].getX(), squares[0][1].getY());
        Knight wkn2 = new Knight(wk2, "White", squares[0][6].getX(), squares[0][6].getY());
        squares[0][1].setPiece(wkn1);
        squares[0][6].setPiece(wkn2);
        Bitmap bk2 = BitmapFactory.decodeResource(getResources(), R.drawable.black_knight); // פרש שחור
        bk2 = Bitmap.createScaledBitmap(bk2, w, w, true);
        Knight bkn1 = new Knight(bk2, "Black", squares[7][1].getX(), squares[7][1].getY());
        Knight bkn2 = new Knight(bk2, "Black", squares[7][6].getX(), squares[7][6].getY());
        squares[7][1].setPiece(bkn1);
        squares[7][6].setPiece(bkn2);
        Bitmap wb = BitmapFactory.decodeResource(getResources(), R.drawable.white_bishop); // רץ לבן
        wb = Bitmap.createScaledBitmap(wb, w, w, true);
        Bishop wb1 = new Bishop(wb, "White", squares[0][2].getX(), squares[0][2].getY());
        Bishop wb2 = new Bishop(wb, "White", squares[0][5].getX(), squares[0][5].getY());
        squares[0][2].setPiece(wb1);
        squares[0][5].setPiece(wb2);
        Bitmap bb = BitmapFactory.decodeResource(getResources(), R.drawable.black_bishop); // רץ שחור
        bb = Bitmap.createScaledBitmap(bb, w, w, true);
        Bishop bb1 = new Bishop(bb, "Black", squares[7][2].getX(), squares[7][2].getY());
        Bishop bb2 = new Bishop(bb, "Black", squares[7][5].getX(), squares[7][5].getY());
        squares[7][2].setPiece(bb1);
        squares[7][5].setPiece(bb2);


    }


    private void drawBoard(Canvas canvas) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                squares[i][j].draw(canvas);
            }
        }
    }

    private void initBoard(Canvas canvas) {
        int x = 0;
        int y = 0;
        w = canvas.getWidth() / NUM_OF_SQUARES;
        h = w;
        int color;

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < NUM_OF_SQUARES; j++) {
                if (i % 2 == 0)  // Even lines  שורות זוגיות
                {
                    if (j % 2 == 0)
                        color = Color.WHITE;
                    else
                        color = Color.GRAY;

                } else {   // Odd lines   שורות אי זוגיות
                    if (j % 2 == 0)
                        color = Color.GRAY;
                    else
                        color = Color.WHITE;
                }
                squares[i][j] = new Square(x, y, w, h, color);
                x = x + w;
            }
            x = 0;
            y = y + h;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) { // כאשר לוחצים על המסך
        int xloc = (int) event.getX();
        int yloc = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if ((xloc > 0 && xloc < h * NUM_OF_SQUARES) && (yloc > 0 && yloc < h * NUM_OF_SQUARES)) { // בודק אם לוחצים על הלוח
                currX = xloc;
                currY = yloc;
                userTouchSquareBefore(); // בודק באיזו משבצת נגע המשתמש
                if (squares[x1][y1].getPiece() != null) {
                    tempPiece = squares[x1][y1].getPiece(); // מגדיר חתיכה (חייל) זמני
                } else {
                    tempPiece = null;
                }
            }
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {

        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if ((xloc > 0 && xloc < h * NUM_OF_SQUARES) && (yloc > 0 && yloc < h * NUM_OF_SQUARES)) {
                currX = xloc;
                currY = yloc;
                userTouchSquareAfter(); // בודק באיזו משבצת נגע המשתמש
            }
            updatePieceAfterRelease(); // בודק את הלוגיקה והאם המהלך הגיוני. פועל בהתאם.
        }


        return true;
    }

    private void userTouchSquareBefore() //when clicking the board
    {
        x1 = 0;
        y1 = 0;
        for (int i = 0; i < NUM_OF_SQUARES; i++) {
            for (int j = 0; j < NUM_OF_SQUARES; j++) {
                if (squares[i][j].didUserTouchMe(currX, currY)) {
                    x1 = i;
                    y1 = j;
                }
            }
        }
    }

    private void userTouchSquareAfter() // after releasing the mouse
    {
        x2 = 0;
        y2 = 0;
        for (int i = 0; i < NUM_OF_SQUARES; i++) {
            for (int j = 0; j < NUM_OF_SQUARES; j++) {
                if (squares[i][j].didUserTouchMe(currX, currY)) {
                    x2 = i;
                    y2 = j;
                }
            }
        }
    }

    private void updatePieceAfterRelease() // בודק אם המהלך חוקי ואם כן משנה בהתאם ואם לא מחזיר את המצב לקדמותו
    {
        if (tempPiece != null) {
            if (tempPiece.getColor().equals(turn) && turn.equals("White") && (turncolor.equals(turn) || turncolor.equals("Offline")))
            { // בודק אם צבע החייל שהוזז תואם לצבע התור
                if (tempPiece != null) {
                    if (tempPiece instanceof Pawn) {
                        tempPawn = (Pawn) tempPiece;
                        whitepawn();
                    } else if (tempPiece instanceof Bishop) {
                        whitebishop();
                    } else if (tempPiece instanceof Knight) {
                        whiteknight();
                    } else if (tempPiece instanceof Rook) {
                        tempRook = (Rook) tempPiece;
                        whiterook();
                    } else if (tempPiece instanceof Queen) {
                        whitequeen();
                    } else if (tempPiece instanceof King) {
                        tempKing = (King) tempPiece;
                        whiteking();
                    }
                }

            } else if (tempPiece.getColor().equals(turn) && turn.equals("Black") && (turncolor.equals(turn) || turncolor.equals("Offline"))) {
                if (tempPiece != null) {
                    if (tempPiece instanceof Pawn) {
                        tempPawn = (Pawn) tempPiece;
                        blackpawn();
                    } else if (tempPiece instanceof Bishop) {
                        blackbishop();
                    } else if (tempPiece instanceof Knight) {
                        blackknight();
                    } else if (tempPiece instanceof Rook) {
                        tempRook = (Rook) tempPiece;
                        blackrook();
                    } else if (tempPiece instanceof Queen) {
                        blackqueen();
                    } else if (tempPiece instanceof King) {
                        tempKing = (King) tempPiece;
                        blackking();
                    }
                }
            } else if (tempPiece.getColor() != turn) {
                squares[x1][y1].setPiece(tempPiece);
            }
        }
    }




    private void whitepawn() {
        if (tempPawn.getisFirstMove() == true) {
            if (y2 - y1 == 0 && x2 - x1 == 2 && squares[x2][y2].getPiece() == null && squares[x2-1][y2].getPiece() == null) {
                whitepawnfirstmove();
            }
            else if (y2 - y1 == 0 && x2 - x1 == 1 && squares[x2][y2].getPiece() == null) {
                whitepawnfirstmove();
            }
            else if (y2 - y1 == -1 && x2 - x1 == 1 && squares[x2][y2].getPiece()!=null && squares[x2][y2].getPiece().getColor() == "Black") {
                whitepawnfirstmove();
            } else if (y2 - y1 == 1 && x2 - x1 == 1 && squares[x2][y2].getPiece()!=null && squares[x2][y2].getPiece().getColor() == "Black") {
                whitepawnfirstmove();
            }
            else
            {
                squares[x1][y1].setPiece(tempPiece);
            }
        }
        else if (tempPawn.getisFirstMove() == false) {
            if (y2 - y1 == 0 && x2 - x1 == 1 && squares[x2][y2].getPiece() == null) {
                whitepawnmove();
            } else if (y2 - y1 == -1 && x2 - x1 == 1 && squares[x2][y2].getPiece()!=null && squares[x2][y2].getPiece().getColor() == "Black") {
                whitepawnmove();
            } else if (y2 - y1 == 1 && x2 - x1 == 1 && squares[x2][y2].getPiece()!=null && squares[x2][y2].getPiece().getColor() == "Black") {
                whitepawnmove();
            }
            else
            {
                squares[x1][y1].setPiece(tempPiece);
            }

        }
        invalidate();
    }
    private void whitepawnfirstmove() {
        tempPawn.setFirstMove(false);
        Move move = new Move(x1,y1,x2,y2);
        ((GameActivity)context).setNewMoveToFb(move);
        ((GameActivity)context).setSound();
    }
    private void whitepawnmove() {
        Move move = new Move(x1,y1,x2,y2);
        ((GameActivity)context).setNewMoveToFb(move);
        ((GameActivity)context).setSound();
    }



    private void blackpawn() {
        if (tempPawn.getisFirstMove() == true) {
            if (y2 - y1 == 0 && x2 - x1 == -2 && squares[x2][y2].getPiece() == null && squares[x2+1][y2].getPiece() == null) {
                blackpawnfirstmove();
            }
            else if (y2 - y1 == 0 && x2 - x1 == -1 && squares[x2][y2].getPiece() == null) {
                blackpawnfirstmove();
            }
            else if (y2 - y1 == -1 && x2 - x1 == -1 && squares[x2][y2].getPiece()!=null && squares[x2][y2].getPiece().getColor() == "White") {
                blackpawnfirstmove();
            } else if (y2 - y1 == 1 && x2 - x1 == -1 && squares[x2][y2].getPiece()!=null && squares[x2][y2].getPiece().getColor() == "White") {
                blackpawnfirstmove();
            }

            else
            {
                squares[x1][y1].setPiece(tempPiece);
            }
        }
        else if (tempPawn.getisFirstMove() == false) {
            if (y2 - y1 == 0 && x2 - x1 == -1 && squares[x2][y2].getPiece() == null) {
                    blackpawnmove();
            } else if (y2 - y1 == -1 && x2 - x1 == -1 && squares[x2][y2].getPiece()!=null && squares[x2][y2].getPiece().getColor() == "White") {
                blackpawnmove();
            } else if (y2 - y1 == 1 && x2 - x1 == -1 && squares[x2][y2].getPiece()!=null && squares[x2][y2].getPiece().getColor() == "White") {
                blackpawnmove();
            }
            else
            {
                squares[x1][y1].setPiece(tempPiece);
            }

        }
        invalidate();
    }
    private void blackpawnfirstmove() {
        tempPawn.setFirstMove(false);
        Move move = new Move(x1,y1,x2,y2);
        ((GameActivity)context).setNewMoveToFb(move);
        ((GameActivity)context).setSound();
    }
    private void blackpawnmove() {
        Move move = new Move(x1,y1,x2,y2);
        ((GameActivity)context).setNewMoveToFb(move);
        ((GameActivity)context).setSound();
    }


    private void whiteknight() {
        if (y2 - y1 == 1 && x2 - x1 == 2 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black")) {
            whiteknightmove();
        }
        else if (y2 - y1 == 1 && x2 - x1 == -2 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black")){
            whiteknightmove();
        }
        else if (y2 - y1 == -1 && x2 - x1 == 2 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black")){
            whiteknightmove();
        }
        else if (y2 - y1 == -1 && x2 - x1 == -2 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black")){
            whiteknightmove();
        }
        else if (y2 - y1 == 2 && x2 - x1 == 1 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black")){
            whiteknightmove();
        }
        else if (y2 - y1 == 2 && x2 - x1 == -1 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black")){
            whiteknightmove();
        }
        else if (y2 - y1 == -2 && x2 - x1 == 1 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black")){
            whiteknightmove();
        }
        else if (y2 - y1 == -2 && x2 - x1 == -1 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black")){
            whiteknightmove();
        }
        else{
            squares[x1][y1].setPiece(tempPiece);

        }
        invalidate();
    }

    private void whiteknightmove() {
        Move move = new Move(x1,y1,x2,y2);
        ((GameActivity)context).setNewMoveToFb(move);
        ((GameActivity)context).setSound();
    }

    private void blackknight() {
        if (y2 - y1 == 1 && x2 - x1 == 2 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White")) {
            blackknightmove();
        }
        else if (y2 - y1 == 1 && x2 - x1 == -2 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White")){
            blackknightmove();
        }
        else if (y2 - y1 == -1 && x2 - x1 == 2 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White")){
            blackknightmove();
        }
        else if (y2 - y1 == -1 && x2 - x1 == -2 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White")){
            blackknightmove();
        }
        else if (y2 - y1 == 2 && x2 - x1 == 1 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White")){
            blackknightmove();
        }
        else if (y2 - y1 == 2 && x2 - x1 == -1 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White")){
            blackknightmove();
        }
        else if (y2 - y1 == -2 && x2 - x1 == 1 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White")){
            blackknightmove();
        }
        else if (y2 - y1 == -2 && x2 - x1 == -1 && (squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White")){

            blackknightmove();
        }
        else{
            squares[x1][y1].setPiece(tempPiece);
        }
        invalidate();
    }

    private void blackknightmove() {
        Move move = new Move(x1,y1,x2,y2);
        ((GameActivity)context).setNewMoveToFb(move);
        ((GameActivity)context).setSound();
    }

    private void whitebishop() {
        boolean flag = true;
        if(squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black"){
            if(x2-x1==y2-y1&& x2>x1){
                for (int i = 1; i < x2-x1; i++){
                    if (squares[x1+i][y1+i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if(x2-x1==y2-y1&& x2<x1){
                for (int i = 1; i < x1-x2; i++){
                    if (squares[x1-i][y1-i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x1-x2==y2-y1&& x2>x1){
                for (int i = 1; i < x2-x1; i++){
                    if (squares[x1+i][y1-i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x1-x2==y2-y1&& x2<x1){
                for (int i = 1; i < x1-x2; i++){
                    if (squares[x1-i][y1+i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else{
                flag=false;
            }
            if (flag == true){
                Move move = new Move(x1,y1,x2,y2);
                ((GameActivity)context).setNewMoveToFb(move);
                ((GameActivity)context).setSound();
            }
            else {
                squares[x1][y1].setPiece(tempPiece);
            }
        }
        invalidate();
    }
    private void blackbishop() {
        boolean flag = true;
        if(squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White"){
            if(x2-x1==y2-y1&& x2>x1){
                for (int i = 1; i < x2-x1; i++){
                    if (squares[x1+i][y1+i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if(x2-x1==y2-y1&& x2<x1){
                for (int i = 1; i < x1-x2; i++){
                    if (squares[x1-i][y1-i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x1-x2==y2-y1&& x2>x1){
                for (int i = 1; i < x2-x1; i++){
                    if (squares[x1+i][y1-i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x1-x2==y2-y1&& x2<x1){
                for (int i = 1; i < x1-x2; i++){
                    if (squares[x1-i][y1+i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else{
                flag=false;
            }
            if (flag == true){
                Move move = new Move(x1,y1,x2,y2);
                ((GameActivity)context).setNewMoveToFb(move);
                ((GameActivity)context).setSound();
            }
            else {
                squares[x1][y1].setPiece(tempPiece);
            }
        }
        invalidate();
    }
    private void whiterook() {
        boolean flag = true;
        tempRook = (Rook) squares[x1][y1].getPiece();
        if(squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black"){
            if(y2-y1==0 && x2>x1){
                for (int i = 1; i < x2-x1; i++){
                    if (squares[x1+i][y1].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if(y2-y1==0 && x2<x1){
                for (int i = 1; i < x1-x2; i++){
                    if (squares[x1-i][y1].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x2-x1==0 && y2>y1){
                for (int i = 1; i < y2-y1; i++){
                    if (squares[x1][y1+i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x2-x1==0 && y2<y1){
                for (int i = 1; i < y1-y2; i++){
                    if (squares[x1][y1-i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else{
                flag=false;
            }
            if (flag == true){
                Move move = new Move(x1,y1,x2,y2);
                ((GameActivity)context).setNewMoveToFb(move);
                ((GameActivity)context).setSound();
                tempRook.setFirstMove(false);
            }
            else {
                squares[x1][y1].setPiece(tempPiece);
            }
        }
        else if (squares[x2][y2].getPiece() instanceof King && squares[x2][y2].getPiece().getColor()=="White") // בודק האם אפשר לעשות הצרחה ואם כן יעשה זאת
        {
            tempKing = (King) squares[x2][y2].getPiece();
            if (tempKing.getisFirstMove() == true && tempRook.getisFirstMove()==true){
                if(x2-x1==0&&y1-y2==4)
                {
                    for (int i = 1; i < y1-y2; i++){
                        if (squares[x1][y1-i].getPiece()!=null){
                            flag = false;
                        }
                    }
                    if (flag == true){
                        Move move = new Move(x1,y1,x2,y2+1);
                        ((GameActivity)context).setNewMoveToFb(move);
                        ((GameActivity)context).setSound();
                        Move newmove = new Move(0,3,0,5);
                        ((GameActivity)context).setNewMoveToFb(newmove);
                        tempKing.setFirstMove(false);
                        tempRook.setFirstMove(false);
                        turn = "Black";
                    }
                    else {
                        squares[x1][y1].setPiece(tempPiece);
                    }
                }
                else if (x2-x1==0&&y2-y1==3)
                {
                    for (int i = 1; i < y2-y1; i++){
                        if (squares[x1][y1+i].getPiece()!=null){
                            flag = false;
                        }
                    }
                    if (flag == true){
                        Move move = new Move(x1,y1,x2,y2-1);
                        ((GameActivity)context).setNewMoveToFb(move);
                        ((GameActivity)context).setSound();
                        Move newmove = new Move(0,3,0,1);
                        ((GameActivity)context).setNewMoveToFb(newmove);
                        tempKing.setFirstMove(false);
                        tempRook.setFirstMove(false);
                        turn = "Black";
                    }
                    else {
                        squares[x1][y1].setPiece(tempPiece);
                    }
                }
            }

        }
        invalidate();
    }
    private void blackrook() {
        boolean flag = true;
        tempRook = (Rook) squares[x1][y1].getPiece();

        if(squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White"){
            if(y2-y1==0 && x2>x1){
                for (int i = 1; i < x2-x1; i++){
                    if (squares[x1+i][y1].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if(y2-y1==0 && x2<x1){
                for (int i = 1; i < x1-x2; i++){
                    if (squares[x1-i][y1].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x2-x1==0 && y2>y1){
                for (int i = 1; i < y2-y1; i++){
                    if (squares[x1][y1+i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x2-x1==0 && y2<y1){
                for (int i = 1; i < y1-y2; i++){
                    if (squares[x1][y1-i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else{
                flag=false;
            }
            if (flag == true){
                Move move = new Move(x1,y1,x2,y2);
                ((GameActivity)context).setNewMoveToFb(move);
                ((GameActivity)context).setSound();
                tempRook.setFirstMove(false);
            }
            else {
                squares[x1][y1].setPiece(tempPiece);
            }
        }
        else if (squares[x2][y2].getPiece() instanceof King && squares[x2][y2].getPiece().getColor()=="Black") // בודק האם אפשר לעשות הצרחה ואם כן יעשה זאת
        {
            tempKing = (King) squares[x2][y2].getPiece();
            if (tempKing.getisFirstMove() == true && tempRook.getisFirstMove() == true){
                if(x2-x1==0&&y1-y2==4)
                {
                    for (int i = 1; i < y1-y2; i++){
                        if (squares[x1][y1-i].getPiece()!=null){
                            flag = false;
                        }
                    }
                    if (flag == true){
                        Move move = new Move(x1,y1,x2,y2+1);
                        ((GameActivity)context).setNewMoveToFb(move);
                        ((GameActivity)context).setSound();
                        Move newmove = new Move(7,3,7,5);
                        ((GameActivity)context).setNewMoveToFb(newmove);
                        tempKing.setFirstMove(false);
                        tempRook.setFirstMove(false);
                        turn = "White";
                    }
                    else {
                        squares[x1][y1].setPiece(tempPiece);
                    }
                }
                else if (x2-x1==0&&y2-y1==3)
                {
                    for (int i = 1; i < y2-y1; i++){
                        if (squares[x1][y1+i].getPiece()!=null){
                            flag = false;
                        }
                    }
                    if (flag == true){
                        Move move = new Move(x1,y1,x2,y2-1);
                        ((GameActivity)context).setNewMoveToFb(move);
                        ((GameActivity)context).setSound();
                        Move newmove = new Move(7,3,7,1);
                        ((GameActivity)context).setNewMoveToFb(newmove);
                        tempKing.setFirstMove(false);
                        tempRook.setFirstMove(false);
                        turn = "White";
                    }
                    else {
                        squares[x1][y1].setPiece(tempPiece);
                    }
                }
            }

        }
        invalidate();

    }
    private void whitequeen() {
        whitebishop();

        boolean flag = true;
        if(squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "Black"){
            if(y2-y1==0 && x2>x1){
                for (int i = 1; i < x2-x1; i++){
                    if (squares[x1+i][y1].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if(y2-y1==0 && x2<x1){
                for (int i = 1; i < x1-x2; i++){
                    if (squares[x1-i][y1].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x2-x1==0 && y2>y1){
                for (int i = 1; i < y2-y1; i++){
                    if (squares[x1][y1+i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x2-x1==0 && y2<y1){
                for (int i = 1; i < y1-y2; i++){
                    if (squares[x1][y1-i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else{
                flag=false;
            }
            if (flag == true){
                Move move = new Move(x1,y1,x2,y2);
                ((GameActivity)context).setNewMoveToFb(move);
                ((GameActivity)context).setSound();
            }
            else {
                squares[x1][y1].setPiece(tempPiece);
            }
        }
        invalidate();
    }
    private void blackqueen() {
        blackbishop();

        boolean flag = true;
        if(squares[x2][y2].getPiece() == null || squares[x2][y2].getPiece().getColor() == "White"){
            if(y2-y1==0 && x2>x1){
                for (int i = 1; i < x2-x1; i++){
                    if (squares[x1+i][y1].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if(y2-y1==0 && x2<x1){
                for (int i = 1; i < x1-x2; i++){
                    if (squares[x1-i][y1].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x2-x1==0 && y2>y1){
                for (int i = 1; i < y2-y1; i++){
                    if (squares[x1][y1+i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else if (x2-x1==0 && y2<y1){
                for (int i = 1; i < y1-y2; i++){
                    if (squares[x1][y1-i].getPiece()!=null){
                        flag = false;
                    }
                }
            }
            else{
                flag=false;
            }
            if (flag == true){
                Move move = new Move(x1,y1,x2,y2);
                ((GameActivity)context).setNewMoveToFb(move);
                ((GameActivity)context).setSound();
            }
            else {
                squares[x1][y1].setPiece(tempPiece);
            }
        }
        invalidate();
    }
    private void whiteking() {
        boolean flag = true;
        tempKing = (King) squares[x1][y1].getPiece();
        if (x2-x1==1&&y2-y1==0&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="Black")){
            whitekingmove();
        } else if (x2-x1==-1&&y2-y1==0&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="Black")) {
            whitekingmove();
        }
        else if (x2-x1==0&&y2-y1==1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="Black")) {
            whitekingmove();
        }
        else if (x2-x1==0&&y2-y1==-1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="Black")) {
            whitekingmove();
        }
        else if (x2-x1==1&&y2-y1==1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="Black")) {
            whitekingmove();
        }
        else if (x2-x1==1&&y2-y1==-1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="Black")) {
            whitekingmove();
        }
        else if (x2-x1==-1&&y2-y1==1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="Black")) {
            whitekingmove();
        }
        else if (x2-x1==-1&&y2-y1==-1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="Black")) {
            whitekingmove();
        }
        else if (squares[x2][y2].getPiece() instanceof Rook && squares[x2][y2].getPiece().getColor()=="White") // בודק האם אפשר לעשות הצרחה ואם כן יעשה זאת
        {
            tempRook = (Rook) squares[x2][y2].getPiece();
            if (tempKing.getisFirstMove() == true && tempRook.getisFirstMove() == true){
                if(x2-x1==0&&y2-y1==4)
                {
                    for (int i = 1; i < y2-y1; i++){
                        if (squares[x1][y1+i].getPiece()!=null){
                            flag = false;
                        }
                    }
                    if (flag == true){
                        Move move = new Move(0,3,0,5);
                        ((GameActivity)context).setNewMoveToFb(move);
                        ((GameActivity)context).setSound();
                        Move newmove = new Move(0,7,0,4);
                        ((GameActivity)context).setNewMoveToFb(newmove);
                        tempKing.setFirstMove(false);
                        tempRook.setFirstMove(false);
                        turn = "Black";
                    }
                    else {
                        squares[x1][y1].setPiece(tempPiece);
                    }
                }
                else if (x2-x1==0&&y1-y2==3)
                {
                    for (int i = 1; i < y1-y2; i++){
                        if (squares[x1][y1-i].getPiece()!=null){
                            flag = false;
                        }
                    }
                    if (flag == true){
                        Move move = new Move(0,3,0,1);
                        ((GameActivity)context).setNewMoveToFb(move);
                        ((GameActivity)context).setSound();
                        Move newmove = new Move(0,0,0,2);
                        ((GameActivity)context).setNewMoveToFb(newmove);
                        tempKing.setFirstMove(false);
                        tempRook.setFirstMove(false);
                        turn = "Black";
                    }
                    else {
                        squares[x1][y1].setPiece(tempPiece);
                    }
                }
            }
        }
        else {
            squares[x1][y1].setPiece(tempPiece);
        }
        invalidate();
    }

    private void whitekingmove() {
        Move move = new Move(x1,y1,x2,y2);
        ((GameActivity)context).setNewMoveToFb(move);
        ((GameActivity)context).setSound();
        tempKing.setFirstMove(false);
    }

    private void blackking() {
        boolean flag = true;
        tempKing = (King) squares[x1][y1].getPiece();
        if (x2-x1==1&&y2-y1==0&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="White")){
            blackkingmove();
        } else if (x2-x1==-1&&y2-y1==0&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="White")) {
            blackkingmove();
        }
        else if (x2-x1==0&&y2-y1==1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="White")) {
            blackkingmove();
        }
        else if (x2-x1==0&&y2-y1==-1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="White")) {
            blackkingmove();
        }
        else if (x2-x1==1&&y2-y1==1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="White")) {
            blackkingmove();
        }
        else if (x2-x1==1&&y2-y1==-1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="White")) {
            blackkingmove();
        }
        else if (x2-x1==-1&&y2-y1==1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="White")) {
            blackkingmove();
        }
        else if (x2-x1==-1&&y2-y1==-1&&(squares[x2][y2].getPiece()==null||squares[x2][y2].getPiece().getColor()=="White")) {
            blackkingmove();
        }
        else if (squares[x2][y2].getPiece() instanceof Rook && squares[x2][y2].getPiece().getColor()=="Black") // בודק האם אפשר לעשות הצרחה ואם כן יעשה זאת
        {
            tempRook = (Rook) squares[x2][y2].getPiece();
            if (tempKing.getisFirstMove() == true && tempRook.getisFirstMove() == true){
                if(x2-x1==0&&y2-y1==4)
                {
                    for (int i = 1; i < y2-y1; i++){
                        if (squares[x1][y1+i].getPiece()!=null){
                            flag = false;
                        }
                    }
                    if (flag == true){
                        Move move = new Move(7,3,7,5);
                        ((GameActivity)context).setNewMoveToFb(move);
                        ((GameActivity)context).setSound();
                        Move newmove = new Move(7,7,7,4);
                        ((GameActivity)context).setNewMoveToFb(newmove);
                        tempKing.setFirstMove(false);
                        tempRook.setFirstMove(false);
                        turn = "White";

                    }
                    else {
                        squares[x1][y1].setPiece(tempPiece);
                    }
                }
                else if (x2-x1==0&&y1-y2==3)
                {
                    for (int i = 1; i < y1-y2; i++){
                        if (squares[x1][y1-i].getPiece()!=null){
                            flag = false;
                        }
                    }
                    if (flag == true){
                        Move move = new Move(7,3,7,1);
                        ((GameActivity)context).setNewMoveToFb(move);
                        ((GameActivity)context).setSound();
                        Move newmove = new Move(7,0,7,2);
                        ((GameActivity)context).setNewMoveToFb(newmove);
                        tempKing.setFirstMove(false);
                        tempRook.setFirstMove(false);
                        turn = "White";
                    }
                    else {
                        squares[x1][y1].setPiece(tempPiece);
                    }
                }
            }
        }
        else {
            squares[x1][y1].setPiece(tempPiece);
        }
        invalidate();
    }

    private void blackkingmove() {
        Move move = new Move(x1,y1,x2,y2);
        ((GameActivity)context).setNewMoveToFb(move);
        ((GameActivity)context).setSound();
        tempKing.setFirstMove(false);
    }

    public void setMove (Move move){ // sorted by colors
        int beforeX = move.getOldX();
        int beforeY = move.getOldY();
        int afterX = move.getNewX();
        int afterY = move.getNewY();
        if(squares[afterX][afterY].getPiece()!=null && squares[afterX][afterY].getPiece() instanceof King && squares[afterX][afterY].getPiece().getColor().equals("Black") && squares[beforeX][beforeY].getPiece().getColor().equals("White"))
        {
            whitewon();
        }
        else if(squares[afterX][afterY].getPiece()!=null && squares[afterX][afterY].getPiece() instanceof King && squares[afterX][afterY].getPiece().getColor().equals("White") && squares[beforeX][beforeY].getPiece().getColor().equals("Black"))
        {
            blackwon();
        }
        if(afterX==7 && squares[beforeX][beforeY].getPiece() instanceof Pawn && squares[beforeX][beforeY].getPiece().getColor().equals("White"))
        {
            Bitmap wq = BitmapFactory.decodeResource(getResources(), R.drawable.white_queen);
            wq = Bitmap.createScaledBitmap(wq, w, w, true);
            squares[afterX][afterY].setPiece(new Queen(wq, "White", squares[x2][y2].getX(), squares[x2][y2].getY()));
            squares[beforeX][beforeY].setPiece(null);

        }
        else if (afterX==0 && squares[beforeX][beforeY].getPiece() instanceof Pawn && squares[beforeX][beforeY].getPiece().getColor().equals("Black"))
        {
            Bitmap bq = BitmapFactory.decodeResource(getResources(), R.drawable.black_queen);
            bq = Bitmap.createScaledBitmap(bq, w, w, true);
            squares[afterX][afterY].setPiece(new Queen(bq, "Black", squares[x2][y2].getX(), squares[x2][y2].getY()));
            squares[beforeX][beforeY].setPiece(null);
        }
        else {
            squares[afterX][afterY].setPiece(squares[beforeX][beforeY].getPiece());
            squares[beforeX][beforeY].setPiece(null);
        }
        if (turn.equals("White")){
            turn = "Black";
        }
        else if (turn.equals("Black")){
            turn = "White";
        }
        invalidate();
    }
    private void whitewon() {
        firstTime = true;
        invalidate();
        ((GameActivity)context).setSoundWin();
        ((GameActivity)context).resultToMainActivity("White");
    }
    private void blackwon() {
        firstTime = true;
        invalidate();
        ((GameActivity)context).setSoundWin();
        ((GameActivity)context).resultToMainActivity("Black");
    }


}