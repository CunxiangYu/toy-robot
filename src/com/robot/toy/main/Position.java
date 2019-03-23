package com.robot.toy.main;

public class Position {

    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 4;

    private int x;
    private int y;
    private FaceDirection faceDirection;

    public Position(int x, int y, FaceDirection faceDirection) {
        this.x = x;
        this.y = y;
        this.faceDirection = faceDirection;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setFaceDirection(FaceDirection faceDirection) {
        this.faceDirection = faceDirection;
    }

    public FaceDirection getFaceDirection() {
        return this.faceDirection;
    }
}
