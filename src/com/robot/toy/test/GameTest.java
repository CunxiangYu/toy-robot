package com.robot.toy.test;

import com.robot.toy.main.Game;
import com.robot.toy.main.Robot;
import com.robot.toy.main.enums.FaceDirection;
import com.robot.toy.main.exceptions.ToyRobotException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testExecuteCommand() throws ToyRobotException {
        Robot robot = new Robot();
        Game game = new Game(robot);

        // Exception is thrown if user tries to manipulate robot before placing it on table
        Assertions.assertThrows(ToyRobotException.class, () -> {
            game.executeCommand("MOVE");
        });
        Assertions.assertThrows(ToyRobotException.class, () -> {
            game.executeCommand("LEFT");
        });
        Assertions.assertThrows(ToyRobotException.class, () -> {
            game.executeCommand("RIGHT");
        });
        Assertions.assertThrows(ToyRobotException.class, () -> {
            game.executeCommand("REPORT");
        });

        // Robot moves and rotates when placed on table
        game.executeCommand("PLACE 0,1,EAST");
        Assertions.assertEquals(0, robot.getPosition().getX());
        Assertions.assertEquals(1, robot.getPosition().getY());
        Assertions.assertEquals(FaceDirection.EAST, robot.getPosition().getFaceDirection());

        game.executeCommand("MOVE");
        game.executeCommand("RIGHT");
        game.executeCommand("MOVE");
        Assertions.assertEquals(1, robot.getPosition().getX());
        Assertions.assertEquals(0, robot.getPosition().getY());
        Assertions.assertEquals(FaceDirection.SOUTH, robot.getPosition().getFaceDirection());

        // Tests with invalid user inputs
        Assertions.assertThrows(ToyRobotException.class, () -> {
           game.executeCommand("INVALID");
        });
        Assertions.assertThrows(ToyRobotException.class, () -> {
            game.executeCommand("Another invalid command");
        });
        Assertions.assertThrows(ToyRobotException.class, () -> {
            game.executeCommand("PLACE");
        });
        Assertions.assertThrows(ToyRobotException.class, () -> {
            game.executeCommand("PLACE1,3,NORTH");
        });

    }
}
