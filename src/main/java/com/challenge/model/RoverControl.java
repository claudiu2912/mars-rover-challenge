package com.challenge.model;

import java.util.Objects;

/**
 * Represents possible operations of controlling a rover, like rotating or moving
 * on a {@link Plateau}.
 */
public enum RoverControl {

    SPIN_90_DEG_LEFT("L"), SPIN_90_DEG_RIGHT("R"), MOVE_FORWARD_ONE_GRID_POINT("M");

    private final String value;

    RoverControl(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Returns a {@link RoverControl} instance from the given {@code value},
     * or throws an exception if none was found.
     *
     * @param value value to find a corresponding {@link RoverControl} for
     * @return a {@link RoverControl} instance from the given {@code value}
     */
    public static RoverControl fromValue(final String value) {
        Objects.requireNonNull(value);

        for (RoverControl control : values()) {
            if (control.getValue().equals(value)) {
                return control;
            }
        }
        throw new IllegalArgumentException("No rover control exists for: " + value);
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
