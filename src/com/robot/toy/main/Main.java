package com.robot.toy.main;

import com.robot.toy.main.exceptions.ToyRobotException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Robot robot = new Robot();
        Game game = new Game(robot);
        Scanner scan = new Scanner(System.in);

        System.out.println("Toy Robot game started...");
        System.out.println("Valid commands are: MOVE, LEFT, RIGHT, REPORT, EXIT and PLACE X,Y,F");
        System.out.println("Please place the robot on the table");

        boolean keepRunning = true;
        while (keepRunning) {
            String input = scan.nextLine();
            try {
                if (input.equals("EXIT")) {
                    keepRunning = false;
                } else {
                    game.executeCommand(input);
                }
            } catch (ToyRobotException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
