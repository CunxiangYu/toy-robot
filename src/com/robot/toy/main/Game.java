package com.robot.toy.main;

import com.robot.toy.main.enums.Command;
import com.robot.toy.main.enums.FaceDirection;
import com.robot.toy.main.exceptions.ToyRobotException;

import static com.robot.toy.main.Position.*;

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
        } else {
            throw new ToyRobotException("Sorry robot is not on table");
        }

    }

    private boolean isRobotOnTable() {
        return robot.getPosition() != null;
    }

    private void placeRobot(int positionX, int positionY, FaceDirection faceDirection) throws ToyRobotException {
        Position newPosition = new Position(positionX, positionY, faceDirection);
        if (!isValidPosition(newPosition)) {
            throw new ToyRobotException("Invalid Position");
        }
        robot.setPosition(newPosition);
    }

    private void report() {
        Position currentPosition = robot.getPosition();
        int x = currentPosition.getX();
        int y = currentPosition.getY();
        FaceDirection faceDirection = currentPosition.getFaceDirection();

        System.out.println("Current position: " + x + "," + y + "," + faceDirection);
    }
}
