package com.challenge.main;

import com.challenge.model.Plateau;
import com.challenge.model.Rover;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point into this application, used for smoke testing the code.
 */
public class MarsRoverChallengeMain {

    private static final String TEST_INPUT_PATH = "src/test/resources/input/rovers-in.txt";

    public static void main(String[] args) throws IOException {
        var lines = Files.readAllLines(Paths.get(TEST_INPUT_PATH));
        var plateau = Plateau.fromLine(lines.get(0));
        var rovers = Rover.parseRovers(lines);

        System.out.println("\n\n******************************");
        System.out.println("Parsed input: \n");
        System.out.println(plateau);
        rovers.forEach(System.out::println);

        System.out.println("\n\nDeploying rovers...");
        var deploymentResult = plateau.deploy(rovers, true);
        System.out.println("\nDeployment result: \n" + deploymentResult);
        System.out.println("\n\nAll rovers finished moving");
        System.out.println("******************************\n\n");
    }
}
