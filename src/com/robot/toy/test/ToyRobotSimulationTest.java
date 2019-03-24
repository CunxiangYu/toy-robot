package com.robot.toy.test;

import com.robot.toy.main.Main;
import static com.robot.toy.main.Main.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ToyRobotSimulationTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();

    @Test
    public void testToyRobotApp() {
        final InputStream consoleInput = System.in;
        final PrintStream consoleOutput = System.out;
        try {
            final PipedOutputStream testInput = new PipedOutputStream();
            final PipedOutputStream out = new PipedOutputStream();
            final PipedInputStream testOutput = new PipedInputStream(out);
            System.setIn(new PipedInputStream(testInput));
            System.setOut(new PrintStream(out));
            new Thread(() -> {
                try {
                    PrintStream testPrint = new PrintStream(testInput);
                    BufferedReader testReader = new BufferedReader(new InputStreamReader(testOutput));
                    Assertions.assertEquals("Toy Robot game started...", testReader.readLine());
                    Assertions.assertEquals("Valid commands are: MOVE, LEFT, RIGHT, REPORT, EXIT and PLACE X,Y,F", testReader.readLine());
                    Assertions.assertEquals("Please place the robot on the table", testReader.readLine());

                    testPrint.println("PLACE 0,0,NORTH");
                    testPrint.println("MOVE");
                    testPrint.println("REPORT");
                    Assertions.assertEquals("Current position: 0,1,NORTH", testReader.readLine());

                    testPrint.println("PLACE 0,0,NORTH");
                    testPrint.println("LEFT");
                    testPrint.println("REPORT");
                    Assertions.assertEquals("Current position: 0,0,WEST", testReader.readLine());

                    testPrint.println("PLACE 1,2,EAST");
                    testPrint.println("MOVE");
                    testPrint.println("MOVE");
                    testPrint.println("LEFT");
                    testPrint.println("MOVE");
                    testPrint.println("REPORT");
                    Assertions.assertEquals("Current position: 3,3,NORTH", testReader.readLine());

                    // Terminate the app
                    testPrint.println("EXIT");
                    Assertions.assertEquals("Process finished with exit code 0", testReader.readLine());

                } catch (IOException e) {
                    e.printStackTrace(consoleOutput);
                }
            }).start();
            Main.main(new String[] {});
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }

        System.setIn(consoleInput);
        System.setOut(consoleOutput);
    }
}
