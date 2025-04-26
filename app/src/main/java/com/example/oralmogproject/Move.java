package com.example.oralmogproject;

public class Move {

    private int oldX,oldY,newX,newY;

    public Move() { // null move for Firebase
    }


    public Move(int oldX, int oldY, int newX, int newY){

        this.oldX=oldX;
        this.oldY=oldY;
        this.newX = newX;
        this.newY = newY;
    }



    public int getOldX() {
        return oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public int getNewX() {
        return newX;
    }

    public int getNewY() {
        return newY;
    }






}
