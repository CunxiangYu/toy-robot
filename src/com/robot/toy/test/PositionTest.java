package com.robot.toy.test;

import com.robot.toy.main.Position;
import com.robot.toy.main.enums.FaceDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.robot.toy.main.Position.isValidPosition;

public class PositionTest {

    @Test
    public void testIsValidPosition() {
        Assertions.assertTrue(isValidPosition(new Position(0, 1, FaceDirection.EAST)));
        Assertions.assertTrue(isValidPosition(new Position(1, 2, FaceDirection.WEST)));
        Assertions.assertTrue(isValidPosition(new Position(2, 3, FaceDirection.NORTH)));
        Assertions.assertTrue(isValidPosition(new Position(3, 4, FaceDirection.SOUTH)));

        Assertions.assertFalse(isValidPosition(new Position(-1, 2, FaceDirection.EAST)));
        Assertions.assertFalse(isValidPosition(new Position(0, -3, FaceDirection.EAST)));
        Assertions.assertFalse(isValidPosition(new Position(-1, 5, FaceDirection.EAST)));
        Assertions.assertFalse(isValidPosition(new Position(5, 0, FaceDirection.EAST)));
    }

    @Test
    public void testNextPosition() {
        Position position1 = new Position(0, 0, FaceDirection.WEST);
        Assertions.assertEquals(0, position1.nextPosition().getX());
        Assertions.assertEquals(0, position1.nextPosition().getY());
        Assertions.assertEquals(FaceDirection.WEST, position1.nextPosition().getFaceDirection());

        Position position2 = new Position(0, 4, FaceDirection.NORTH);
        Assertions.assertEquals(0, position2.nextPosition().getX());
        Assertions.assertEquals(4, position2.nextPosition().getY());
        Assertions.assertEquals(FaceDirection.NORTH, position2.nextPosition().getFaceDirection());

        Position position3 = new Position(0, 3, FaceDirection.SOUTH);
        Assertions.assertEquals(0, position3.nextPosition().getX());
        Assertions.assertEquals(2, position3.nextPosition().getY());
        Assertions.assertEquals(FaceDirection.SOUTH, position3.nextPosition().getFaceDirection());

        Position position4 = new Position(1, 2, FaceDirection.EAST);
        Assertions.assertEquals(2, position4.nextPosition().getX());
        Assertions.assertEquals(2, position4.nextPosition().getY());
        Assertions.assertEquals(FaceDirection.EAST, position4.nextPosition().getFaceDirection());
    }
}
