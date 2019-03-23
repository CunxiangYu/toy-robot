package com.robot.toy.main;

import com.robot.toy.main.exception.ToyRobotException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Robot robot = new Robot();
        Game game = new Game(robot);
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
