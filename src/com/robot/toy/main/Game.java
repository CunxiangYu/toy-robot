package com.robot.toy.main;

import com.robot.toy.main.exception.ToyRobotException;

public class Game {

    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 4;

    private Robot robot;

    public Game(Robot robot) {
        this.robot = robot;
    }



    public void executeCommand(String userInput) throws ToyRobotException {
        String[] args = userInput.split(" ");
        Command command;
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new ToyRobotException("Invalid Command");
        }

        if (command == Command.PLACE) {
            if (args.length != 2) {
                throw new ToyRobotException("Invalid Command");
            }

            int positionX;
            int positionY;
            FaceDirection faceDirection;
            String[] params = args[1].split(",");

            try {
                positionX = Integer.parseInt(params[0]);
                positionY = Integer.parseInt(params[1]);
                faceDirection = FaceDirection.valueOf(params[2]);
            } catch (Exception e) {
                throw new ToyRobotException("Invalid Command");
            }
            placeRobot(positionX, positionY, faceDirection);
        }

        if (isRobotOnTable()) {
            switch (command) {
                case LEFT:
                    robot.rotateLeft();
                    break;
                case RIGHT:
                    robot.rotateRight();
                    break;
                case MOVE:
                    robot.move();
                    break;
                case REPORT:
                    report();
                    break;
            }
        }

    }

    private boolean isRobotOnTable() {
        return robot.getPosition() != null;
    }

    private void placeRobot(int positionX, int positionY, FaceDirection faceDirection) throws ToyRobotException {
        if (positionX < MIN_POSITION || positionX > MAX_POSITION || positionY < MIN_POSITION || positionY > MAX_POSITION) {
            throw new ToyRobotException("Invalid Position");
        }

        robot.setPosition(new Position(positionX, positionY, faceDirection));
    }

    private void report() {
        Position currentPosition = robot.getPosition();

        System.out.println("Current X: " + currentPosition.getX());
        System.out.println("Current Y: " + currentPosition.getY());
        System.out.println("Current Face Direction: " + currentPosition.getFaceDirection());
    }
}
