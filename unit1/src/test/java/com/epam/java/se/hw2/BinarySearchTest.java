package com.epam.java.se.hw2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void findItemTest() throws Exception {
        Integer[] array = {1,2,3,4,5,6,7,8,9,12,60};
        List<Integer> data = new ArrayList<>();
        Collections.addAll(data, array);
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.findItem(data, 2);
        assertEquals(1, index);
        int item = binarySearch.findItem(data, 60);
        assertEquals(10, item);
    }
    @Test
    public void thrownExceptionTest(){
        Integer[] array = {6,2,3,4,7,6,7,8,10,12,60};
        List<Integer> data = new ArrayList<>();
        Collections.addAll(data, array);
        BinarySearch binarySearch = new BinarySearch();
        boolean thrown = false;
        try {
            binarySearch.findItem(data, 0);
        }
        catch (IllegalStateException e){
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void singleElemTest(){
        Integer[] array = {60};
        List<Integer> data = new ArrayList<>();
        Collections.addAll(data, array);
        BinarySearch binarySearch = new BinarySearch();
        int item = binarySearch.findItem(data, 60);
        assertEquals(0, item);
    }
    @Test
    public void notInTheListTest(){
        Integer[] array = {1,2,3,4,5,6,7,8,9,12,60};
        List<Integer> data = new ArrayList<>();
        Collections.addAll(data, array);
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.findItem(data, 10000);
        assertEquals(-1, index);
    }
}