package com.epam.java.se.hw3;

import org.junit.Test;

import static org.junit.Assert.*;


public class MergeSortTest {


    @Test
    public void buttonUpSortDegreeOfTwo() throws Exception {
        Integer[] array = {9,8,7,6,5,4,3,2};
        MergeSort sort = new MergeSort();
        sort.buttonUpSort(array);
        for (int i = 1; i < array.length; i++) {
            assertTrue(array[i - 1].compareTo(array[i]) < 0);
        }
    }

    @Test
    public void buttonUpSortNotDegreeOfTwo() throws Exception {
        Integer[] array = {9,8,7,6,5,4,3,2,1,0};
        MergeSort sort = new MergeSort();
        sort.buttonUpSort(array);
        for (int i = 1; i < array.length; i++) {
            assertTrue(array[i - 1].compareTo(array[i]) < 0);
        }
    }

    @Test
    public void stringComparing() throws Exception{
        String[] array = {"a","b", "c", "d"};
        MergeSort sort = new MergeSort();
        sort.buttonUpSort(array);
        for (int i = 1; i < array.length; i++) {
            assertTrue(array[i -1].compareTo(array[i]) < 0);
        }
    }


}