package com.robot.toy.test;

import com.robot.toy.main.Position;
import com.robot.toy.main.Robot;
import com.robot.toy.main.enums.FaceDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {

    @Test
    public void testMove() {
        Robot robot = new Robot(new Position(0, 0, FaceDirection.NORTH));

        robot.move();
        Assertions.assertEquals(0, robot.getPosition().getX());
        Assertions.assertEquals(1, robot.getPosition().getY());
        Assertions.assertEquals(FaceDirection.NORTH, robot.getPosition().getFaceDirection());

        robot.setPosition(new Position(1, 3, FaceDirection.EAST));
        robot.move();
        robot.move();
        robot.move();
        robot.move();
        robot.move();
        Assertions.assertEquals(4, robot.getPosition().getX());
        Assertions.assertEquals(3, robot.getPosition().getY());
        Assertions.assertEquals(FaceDirection.EAST, robot.getPosition().getFaceDirection());
    }

    @Test
    public void testRotateLeft() {
        Robot robot = new Robot(new Position(0, 0, FaceDirection.NORTH));

        robot.rotateLeft();
        Assertions.assertEquals(FaceDirection.WEST, robot.getPosition().getFaceDirection());

        robot.rotateLeft();
        Assertions.assertEquals(FaceDirection.SOUTH, robot.getPosition().getFaceDirection());

        robot.rotateLeft();
        robot.rotateLeft();
        Assertions.assertEquals(FaceDirection.NORTH, robot.getPosition().getFaceDirection());
    }

    @Test
    public void testRotateRight() {
        Robot robot = new Robot(new Position(0, 0, FaceDirection.NORTH));

        robot.rotateRight();
        Assertions.assertEquals(FaceDirection.EAST, robot.getPosition().getFaceDirection());

        robot.rotateRight();
        Assertions.assertEquals(FaceDirection.SOUTH, robot.getPosition().getFaceDirection());

        robot.rotateRight();
        robot.rotateRight();
        Assertions.assertEquals(FaceDirection.NORTH, robot.getPosition().getFaceDirection());
    }
}
