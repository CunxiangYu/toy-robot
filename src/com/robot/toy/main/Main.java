package com.robot.toy.main;

public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.move();
        robot.rotateLeft();
        robot.rotateRight();
        robot.printPosition();
    }
}
