package com.genpt.rovers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.genpt.rovers.Direction;

public class DirectionTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLeft() {
        assertEquals(Direction.W, Direction.N.left());
        assertEquals(Direction.S, Direction.W.left());
        assertEquals(Direction.E, Direction.S.left());
        assertEquals(Direction.N, Direction.E.left());
    }
    @Test
    public void testRight() {
        assertEquals(Direction.E, Direction.N.right());
        assertEquals(Direction.S, Direction.E.right());
        assertEquals(Direction.W, Direction.S.right());
        assertEquals(Direction.N, Direction.W.right());
    }
}
