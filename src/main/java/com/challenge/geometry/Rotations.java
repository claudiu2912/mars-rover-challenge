package com.challenge.geometry;

import com.challenge.model.Direction;

import java.util.Objects;

/**
 * Applies rotations of a given direction/cardinal point clockwise or counterclockwise,
 * at an "angle".
 */
public class Rotations {

    /**
     * Rotates a given direction 90 degrees to the left.
     *
     * @param direction direction to rotate
     * @return a direction obtained by rotating the given {@code direction} to the left
     */
    public static Direction rotate90DegCounterClockwise(final Direction direction) {
        Objects.requireNonNull(direction);

        switch (direction) {
            case NORTH:
                return Direction.WEST;
            case EAST:
                return Direction.NORTH;
            case SOUTH:
                return Direction.EAST;
            case WEST:
                return Direction.SOUTH;
            default:
                throw new IllegalArgumentException("Unsupported direction: " + direction);
        }
    }

    /**
     * Rotates a given direction 90 degrees to the right.
     *
     * @param direction direction to rotate
     * @return a direction obtained by rotating the given {@code direction} to the right
     */
    public static Direction rotate90DegClockwise(final Direction direction) {
        Objects.requireNonNull(direction);

        switch (direction) {
            case NORTH:
                return Direction.EAST;
            case EAST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.WEST;
            case WEST:
                return Direction.NORTH;
            default:
                throw new IllegalArgumentException("Unsupported direction: " + direction);
        }
    }
}
