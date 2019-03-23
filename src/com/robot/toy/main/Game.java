package com.robot.toy.main;

import com.robot.toy.main.exception.ToyRobotException;

public class Game {

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
            placeRobot();
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
        return false;
    }

    private void placeRobot() {
        System.out.println("Robot placed");
    }

    private void report() {
        System.out.println("Report position");
    }
}
