package com.robot.toy.main;

public class Robot {
    private Position position;

    public void move() {
        System.out.println("Robot moved");
    }

    public void rotateLeft() {
        System.out.println("Robot rotated to left");
    }

    public void rotateRight() {
        System.out.println("Robot rotated to right");
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }
}
