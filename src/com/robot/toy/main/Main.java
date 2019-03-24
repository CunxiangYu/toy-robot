package com.robot.toy.main;

import com.robot.toy.main.exceptions.ToyRobotException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Robot robot = new Robot();
        Game game = new Game(robot);

        System.out.println("Toy Robot game started...");
        System.out.println("Valid commands are: MOVE, LEFT, RIGHT, REPORT, and PLACE X,Y,F");
        System.out.println("Please place the robot on the table");
        Scanner scan = new Scanner(System.in);
        while (true) {
            String input = scan.nextLine();
            try {
                game.executeCommand(input);
            } catch (ToyRobotException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
