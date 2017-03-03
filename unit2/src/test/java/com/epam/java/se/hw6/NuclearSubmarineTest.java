package com.epam.java.se.hw6;

import org.junit.Test;

import static org.junit.Assert.*;


public class NuclearSubmarineTest {
    @Test
    public void startEngine() throws Exception {
        NuclearSubmarine nuclearSubmarine = new NuclearSubmarine();
        nuclearSubmarine.startEngine();
        nuclearSubmarine.move();
        assertTrue(nuclearSubmarine.isItsMoving());
        nuclearSubmarine.stop();
        assertFalse(nuclearSubmarine.isItsMoving());
    }

}