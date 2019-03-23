package com.robot.toy.main;

public enum FaceDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public static FaceDirection leftDirectionOf(FaceDirection faceDirection) {
        FaceDirection leftDirection = faceDirection;
        switch (faceDirection) {
            case NORTH:
                leftDirection = WEST;
                break;
            case WEST:
                leftDirection = SOUTH;
                break;
            case SOUTH:
                leftDirection = EAST;
                break;
            case EAST:
                leftDirection = NORTH;
                break;
        }
        return leftDirection;
    }

    public static FaceDirection rightDirectionOf(FaceDirection faceDirection) {
        FaceDirection rightDirection = faceDirection;
        switch (faceDirection) {
            case NORTH:
                rightDirection = EAST;
                break;
            case EAST:
                rightDirection = SOUTH;
                break;
            case SOUTH:
                rightDirection = WEST;
                break;
            case WEST:
                rightDirection = NORTH;
                break;
        }
        return rightDirection;
    }
}
