package com.robot.toy.main;

public class Position {

    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 4;

    private int x;
    private int y;
    private FaceDirection faceDirection;

    public static boolean isValidPosition(Position position) {
        int positionX = position.getX();
        int positionY = position.getY();

        if (positionX < MIN_POSITION || positionX > MAX_POSITION
                || positionY < MIN_POSITION || positionY > MAX_POSITION
        ) {
            return false;
        }

        return true;
    }

    public Position(int x, int y, FaceDirection faceDirection) {
        this.x = x;
        this.y = y;
        this.faceDirection = faceDirection;
    }

    public Position nextPosition() {
        Position nextPosition = new Position(x, y, faceDirection);
        switch (this.faceDirection) {
            case NORTH:
                nextPosition.move(0, 1);
                break;
            case WEST:
                nextPosition.move(-1, 0);
                break;
            case SOUTH:
                nextPosition.move(0, -1);
                break;
            case EAST:
                nextPosition.move(1, 0);
                break;
        }

        return isValidPosition(nextPosition) ? nextPosition : this;
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

    private void move(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }
}
