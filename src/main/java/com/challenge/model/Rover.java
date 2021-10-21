package com.challenge.model;

import com.challenge.constant.Constants;
import com.challenge.geometry.Rotations;
import com.challenge.geometry.Translations;
import com.challenge.geometry.model.Point2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A rover to be deployed on Mars.
 */
public class Rover {
    private String id;
    private int x;
    private int y;
    private Direction direction;
    private List<RoverControl> roverControls;

    public Rover() {
    }

    /**
     * Applies the Rover's controls to itself, effectively translating and rotating the
     * Rover in the given {@code plateau}.
     *
     * @param plateau the {@link Plateau} the Rover moves in
     * @param verbose whether the controls being applied should be logged as the Rover moves
     * @return this Rover
     */
    public Rover applyControls(final Plateau plateau, final boolean verbose) {
        if (verbose) {
            System.out.printf("%nRover %s will start moving. Initial position is: (%s,%s), heading %s %n",
                    id, x, y, direction);
        }
        this.getRoverControls().forEach(c -> {
            this.applyControl(c);
            if (verbose) {
                System.out.printf("Rover %s executed command: [%s]. Current position is: (%s,%s), heading %s %n",
                        id, c, x, y, direction);
            }
        });
        if (verbose) {
            System.out.printf("Rover %s finished moving. Final position is: (%s,%s), heading %s %n",
                    id, x, y, direction);
        }
        return this;
    }

    private void applyControl(final RoverControl control) {
        switch (control) {
            case SPIN_90_DEG_LEFT:
                this.setDirection(Rotations.rotate90DegCounterClockwise(this.direction));
                break;
            case SPIN_90_DEG_RIGHT:
                this.setDirection(Rotations.rotate90DegClockwise(this.direction));
                break;
            case MOVE_FORWARD_ONE_GRID_POINT:
                final int translationCoefficient = 1;
                var translated = Translations.translateForwardTowardsDirection(
                        new Point2D(this.x, this.y),
                        this.direction,
                        translationCoefficient
                );
                /* TODO: Should we verify that the translated point is valid in terms of the
                    Plateau's boundaries (i.e. >= (0,0), <= (maxX, maxY) )? */
                this.setX(translated.getX());
                this.setY(translated.getY());
                break;
            default:
                throw new IllegalArgumentException("Unsupported control: " + control);
        }
    }

    /**
     * Parses Rovers from the given lines, one Rover being parsed from two consecutive lines.
     *
     * @param lines lines to parse into Rovers
     * @return Rovers parsed from the given lines
     */
    public static ArrayList<Rover> parseRovers(final List<String> lines) {
        var rovers = new ArrayList<Rover>();
        var idIndex = 1;
        for (int i = 1; i < lines.size() - 1; i += 2) {
            var rover = fromLines(lines.get(i), lines.get(i + 1));
            rover.setId("R" + idIndex++);
            rovers.add(rover);
        }
        return rovers;
    }

    /**
     * Parses a {@link Rover} from the given lines.
     *
     * @param positionLine line to parse the Rover position from
     * @param controlsLine line to parse the Rover controls from
     * @return a {@link Rover} parsed from the given lines
     */
    public static Rover fromLines(final String positionLine, final String controlsLine) {
        Objects.requireNonNull(positionLine);

        var rover = new Rover();

        parsePosition(positionLine, rover);
        parseControls(controlsLine, rover);

        return rover;
    }

    private static void parsePosition(final String positionLine, final Rover rover) {
        var positionSplit = positionLine.split(Constants.SPACE);
        if (positionSplit.length < 3) {
            throw new IllegalArgumentException("Could not parse a Rovers position from: " + positionLine);
        }
        rover.setX(Integer.parseInt(positionSplit[0]));
        rover.setY(Integer.parseInt(positionSplit[1]));
        rover.setDirection(Direction.fromValue(positionSplit[2]));
    }

    private static void parseControls(final String controlsLine, final Rover rover) {
        if (controlsLine == null || controlsLine.isEmpty()) {
            rover.setRoverControls(List.of());
        } else {
            var controlsSplit = controlsLine.split(Constants.EMPTY_STRING);
            var controls = Arrays.stream(controlsSplit)
                    .map(RoverControl::fromValue)
                    .collect(Collectors.toList());
            rover.setRoverControls(controls);
        }
    }

    public Rover setId(String id) {
        this.id = id;
        return this;
    }

    public Rover setX(int x) {
        this.x = x;
        return this;
    }

    public Rover setY(int y) {
        this.y = y;
        return this;
    }

    public Rover setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public Rover setRoverControls(List<RoverControl> roverControls) {
        this.roverControls = roverControls;
        return this;
    }

    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<RoverControl> getRoverControls() {
        return roverControls;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                ", roverControls=" + roverControls.stream()
                .map(RoverControl::toString)
                .collect(Collectors.joining("")) +
                "}";
    }
}
