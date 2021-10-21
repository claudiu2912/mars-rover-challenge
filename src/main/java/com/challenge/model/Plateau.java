package com.challenge.model;

import com.challenge.constant.Constants;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The Mars plateau where {@link Rover rovers} can be deployed.
 */
public class Plateau {
    private final int minX = 0;
    private final int minY = 0;
    private int maxX;
    private int maxY;

    public Plateau(final int maxX, final int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Deploys a squad of {@link Rover Rovers} into this {@link Plateau}, computing the final
     * position of the {@link Rover Rovers} after all finished moving.
     *
     * @param rovers  squad of {@link Rover Rovers} to deploy
     * @param verbose whether the controls being applied should be logged as the Rovers move
     * @return the final position of the {@link Rover Rovers} after all finished moving, as a concatenated String
     */
    public String deploy(final List<Rover> rovers, final boolean verbose) {
        return rovers.stream()
                .map(r -> r.applyControls(this, verbose))
                .map(r -> String.format("%s %s %s", r.getX(), r.getY(), r.getDirection().getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    /**
     * Parses a {@link Plateau} from the {@code line}.
     *
     * <p>
     * Assuming a line of the form: {@code maxX maxY}, representing the Plateau upper right
     * coordinates.
     * </p>
     *
     * @param line line to parse a {@link Plateau} from
     * @return a {@link Plateau} parsed from the given {@code line}
     */
    public static Plateau fromLine(final String line) {
        Objects.requireNonNull(line);

        var split = line.split(Constants.SPACE);
        if (split.length < 2) {
            throw new IllegalArgumentException("Could not parse plateau coordinates from: " + line);
        }
        return new Plateau(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "minX=" + minX +
                ", minY=" + minY +
                ", maxX=" + maxX +
                ", maxY=" + maxY +
                '}';
    }
}
