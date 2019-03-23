package com.robot.toy.main;

public class Robot {
    private Position position;

    public void move() {
        position = position.nextPosition();
    }

    public void rotateLeft() {
        FaceDirection leftDirection = FaceDirection.leftDirectionOf(position.getFaceDirection());
        position.setFaceDirection(leftDirection);
    }

    public void rotateRight() {
        FaceDirection rightDirection = FaceDirection.rightDirectionOf(position.getFaceDirection());
        position.setFaceDirection(rightDirection);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
