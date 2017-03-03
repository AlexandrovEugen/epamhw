package com.epam.java.se.hw2;


import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {
    @Test
    public void testThatCountingOfSumOfAllOfficeToolsWorksRight(){
        Table onTheTable = new Table();
        onTheTable.addPen(100, "black", "ballpoint", 100L);
        onTheTable.addPencil(100, "soft", 1L);
        onTheTable.addCutter(10, "plastic", 1L);
        onTheTable.addAdhesiveTape(3,"twoSided", 1L);
        onTheTable.addPackOfStickers(1000, "WHITE", 1L);
        onTheTable.addStapler("black", 1L);
        onTheTable.addHolePuncher("plastic", 1L);
        onTheTable.addPackOfDrawingPins(200, "plastic", 1L);
        onTheTable.addPackOfPaperClips(200, 1L);
        onTheTable.addPencilSharpener("automatic", 1L);
        assertEquals(109L, onTheTable.totalSumOfOfficeTools());
    }

    @Test
    public void testThatAllOfficeToolsAreOnTheWorkState(){
        Table onTheTable = new Table();
        onTheTable.addPen(100, "black", "ballpoint", 1000L);
        onTheTable.addPencil(100, "soft", 200L);
        onTheTable.addCutter(10, "plastic", 20000L);
        onTheTable.addAdhesiveTape(3,"twoSided", 2000L);
        onTheTable.addPackOfStickers(1000, "white", 10000L);
        onTheTable.addStapler("black", 1000L);
        onTheTable.addHolePuncher("plastic", 2000L);
        onTheTable.addPackOfDrawingPins(200, "plastic", 2000L);
        onTheTable.addPackOfPaperClips(200, 2000L);
        onTheTable.addPencilSharpener("automatic", 200000L);
        assertTrue(onTheTable.isAllWorksFine());
    }



}