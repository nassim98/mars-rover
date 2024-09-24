package org.rover.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    @Test
    public void testRoverMovement() {
        Rover rover = new Rover(1, 2, Direction.N, 5, 5);
        rover.processInstructions("LMLMLMLMM");
        assertEquals("1 3 N", rover.getPosition());

        Rover rover2 = new Rover(3, 3, Direction.E, 5, 5);
        rover2.processInstructions("MMRMMRMRRM");
        assertEquals("5 1 E", rover2.getPosition());
    }

    @Test
    public void testRoverBoundaryConditions() {
        Rover rover = new Rover(0, 0, Direction.S, 5, 5);
        rover.processInstructions("M");
        assertEquals("0 0 S", rover.getPosition());

        Rover rover2 = new Rover(5, 5, Direction.N, 5, 5);
        rover2.processInstructions("M");
        assertEquals("5 5 N", rover2.getPosition());

        Rover rover3 = new Rover(5, 5, Direction.E, 5, 5);
        rover3.processInstructions("M");
        assertEquals("5 5 E", rover3.getPosition());

        Rover rover4 = new Rover(0, 0, Direction.W, 5, 5);
        rover4.processInstructions("M");
        assertEquals("0 0 W", rover4.getPosition());
    }

    @Test
    public void testInvalidInstructionHandling() {
        Rover rover = new Rover(1, 2, Direction.N, 5, 5);
        rover.processInstructions("MMXLM");
        assertEquals("0 4 W", rover.getPosition());
    }

    @Test
    public void testMultipleRovers() {
        int plateauWidth = 5;
        int plateauHeight = 5;

        Rover rover1 = new Rover(1, 2, Direction.N, plateauWidth, plateauHeight);
        rover1.processInstructions("LMLMLMLMM");
        assertEquals("1 3 N", rover1.getPosition());

        Rover rover2 = new Rover(3, 3, Direction.E, plateauWidth, plateauHeight);
        rover2.processInstructions("MMRMMRMRRM");
        assertEquals("5 1 E", rover2.getPosition());
    }

    @Test
    public void testRoverTurningWithoutMovement() {
        Rover rover = new Rover(1, 2, Direction.N, 5, 5);
        rover.processInstructions("RRR");
        assertEquals("1 2 W", rover.getPosition());

        rover.processInstructions("L");
        assertEquals("1 2 S", rover.getPosition());
    }

    @Test
    public void testRoverMovesToEdge() {
        Rover rover = new Rover(4, 4, Direction.E, 5, 5);
        rover.processInstructions("MMMM");
        assertEquals("5 4 E", rover.getPosition());
    }
}
