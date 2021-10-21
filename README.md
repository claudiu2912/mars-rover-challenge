# mars-rover-challenge

## About
This is the solution to the Mars Rover Challenge.
The projects is written using Java 11 and built using Gradle.
Tests are running via JUnit5.

## Explanation of the approach
Ideally this problem would be solved with more complicated mathematical libraries 
for 2D and 3D space modelling as one can see in areas like JavaFX 2D and JavaFX 3D or 
even game physics libraries.

For brevity, the expression of the Rover's orientation is done by correlating compass points 
one with the other in respect to a certain angle (say 90 degrees).
Ideally this should be modeled using more complex mathematical approaches where actual angles are 
being stored and altered for a Rover.

Doing so, would complicate the translation operations as well, which I assume is out of the 
scope of this challenge.

## Running instructions

### Test Data
Input test data is stored in the _src/test/resources/input/rovers-in.txt_ 
file, it can be altered as needed in order to test the solution.

Output test data (used by the tests) is stored in the _src/test/resources/output/rovers-out-expected.txt_
file.

### Smoke run
_src/main/java/com/challenge/main/MarsRoverChallengeMain.java_ contains a main
method that runs the solution against the input test file described above.
Running this will log into the console the movements that the Rovers are doing from 
deployment to finish.

### Running tests
Run the tests by altering the input and output test data files described above and running:
`./gradlew clean test`
from the root of this repository.