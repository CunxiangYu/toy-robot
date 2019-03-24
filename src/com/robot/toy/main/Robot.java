package com.robot.toy.main;

import com.robot.toy.main.enums.FaceDirection;

public class Robot {
    private Position position;

    public Robot() {}

    public Robot(Position position) {
        this.position = position;
    }

    public void move() {
        setPosition(position.nextPosition());
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
