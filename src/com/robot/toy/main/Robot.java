package com.robot.toy.main;

public class Robot {
    private int positionX = 0;
    private int positionY = 0;
    private FaceDirection faceDirection = FaceDirection.NORTH;

    public void move() {
        System.out.println("Robot moved");
    }

    public void rotateLeft() {
        System.out.println("Robot rotated to left");
    }

    public void rotateRight() {
        System.out.println("Robot rotated to right");
    }

    public void printPosition() {
        System.out.println("Robot is at position (" + positionX + ", " + positionY + ")");
    }
}
