package com.robot.toy.main;

public class Robot {
    private int positionX;
    private int positionY;
    private FaceDirection faceDirection;

    public void move() {
        System.out.println("Robot moved");
    }

    public void rotateLeft() {
        System.out.println("Robot rotated to left");
    }

    public void rotateRight() {
        System.out.println("Robot rotated to right");
    }

}
