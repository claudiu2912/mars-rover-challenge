package com.challenge.geometry;

import com.challenge.geometry.model.Point2D;
import com.challenge.model.Direction;

/**
 * Applies translations of 2D points in space, in a given direction.
 */
public class Translations {


    /**
     * Moves the given {@code point} in the 2D space towards the given {@code direction} with
     * the given {@code gridPoints}.
     *
     * @param point      2D point to move in space
     * @param direction  direction towards moving should occur
     * @param gridPoints number of grid points to move
     * @return the {@link Point2D} obtained by translating the given {@code point}
     * in the given {@code direction}, with the given {@code gridPoints}
     */
    public static Point2D translateForwardTowardsDirection(final Point2D point,
                                                           final Direction direction,
                                                           final int gridPoints) {
        switch (direction) {
            case NORTH:
                return new Point2D(point.getX(), point.getY() + gridPoints);
            case EAST:
                return new Point2D(point.getX() + gridPoints, point.getY());
            case SOUTH:
                return new Point2D(point.getX(), point.getY() - gridPoints);
            case WEST:
                return new Point2D(point.getX() - gridPoints, point.getY());
            default:
                throw new IllegalArgumentException("Unsupported direction: " + direction);
        }
    }
}
