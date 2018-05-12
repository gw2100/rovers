package com.genpt.rovers;

import org.junit.Test;

import com.genpt.rovers.Direction;
import com.genpt.rovers.Location;
import com.genpt.rovers.Rover;
import com.genpt.rovers.command.Command;

import junit.framework.TestCase;

public class RoverTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    @Test
    public void testMovesCommand0() {
        Rover rover = new RoverImpl().land(new Location(1, 2), Direction.N).move(new Command[] {});
        assertEquals("1 2 N", rover.toString());
    }
    @Test
    public void testMovesCommand1() {
        Rover rover = new RoverImpl().land(new Location(1, 2), Direction.N).move(Command.valuesOf("LMLMLMLMM"));
        assertEquals("1 3 N", rover.toString());
    }
    @Test
    public void testMovesCommand2() {
        Rover rover = new RoverImpl().land(new Location(3, 3), Direction.E).move(Command.valuesOf("MMRMMRMRRM"));
        assertEquals("5 1 E", rover.toString());
    }
}
