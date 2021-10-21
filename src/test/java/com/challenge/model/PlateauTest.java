package com.challenge.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    private static final String TEST_INPUT_PATH = "src/test/resources/input/rovers-in.txt";
    private static final String TEST_OUTPUT_PATH = "src/test/resources/output/rovers-out-expected.txt";

    @Test
    void testDeploy_GivenValidRovers_ShouldReturnTheExpectedResult() throws IOException {
        // Given
        var expected = Files.readString(Paths.get(TEST_OUTPUT_PATH));
        var inputLines = Files.readAllLines(Paths.get(TEST_INPUT_PATH));

        var plateau = Plateau.fromLine(inputLines.get(0));
        var rovers = Rover.parseRovers(inputLines);

        // When
        var actual = plateau.deploy(rovers, true);

        // Then
        assertEquals(expected, actual);
    }
}