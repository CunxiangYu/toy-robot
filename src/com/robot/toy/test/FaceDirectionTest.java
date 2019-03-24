package com.robot.toy.test;

import com.robot.toy.main.enums.FaceDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.robot.toy.main.enums.FaceDirection.leftDirectionOf;
import static com.robot.toy.main.enums.FaceDirection.rightDirectionOf;

public class FaceDirectionTest {

    @Test
    public void testLeftDirectionOf() {
        Assertions.assertEquals(FaceDirection.WEST, leftDirectionOf(FaceDirection.NORTH));
        Assertions.assertEquals(FaceDirection.SOUTH, leftDirectionOf(FaceDirection.WEST));
        Assertions.assertEquals(FaceDirection.EAST, leftDirectionOf(FaceDirection.SOUTH));
        Assertions.assertEquals(FaceDirection.NORTH, leftDirectionOf(FaceDirection.EAST));
    }

    @Test
    public void testRightDirectionOf() {
        Assertions.assertEquals(FaceDirection.EAST, rightDirectionOf(FaceDirection.NORTH));
        Assertions.assertEquals(FaceDirection.SOUTH, rightDirectionOf(FaceDirection.EAST));
        Assertions.assertEquals(FaceDirection.WEST, rightDirectionOf(FaceDirection.SOUTH));
        Assertions.assertEquals(FaceDirection.NORTH, rightDirectionOf(FaceDirection.WEST));
    }
}
