package com.challenge.model;

import java.util.Objects;

/**
 * Cardinal compass points representing a {@link Rover rovers} current direction/heading.
 */
public enum Direction {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    private final String value;

    Direction(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Returns a {@link Direction} instance from the given {@code value},
     * or throws an exception if none was found.
     *
     * @param value value to find a corresponding {@link Direction} for
     * @return a {@link Direction} instance from the given {@code value}
     */
    public static Direction fromValue(final String value) {
        Objects.requireNonNull(value);

        for (Direction direction : values()) {
            if (direction.getValue().equals(value)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("No cardinal point (direction) exists for: " + value);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.name(), this.getValue());
    }
}
