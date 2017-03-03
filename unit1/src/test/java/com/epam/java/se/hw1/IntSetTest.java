package com.epam.java.se.hw1;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntSetTest {
    @Test
    public void isSubSet() throws Exception {
        final IntSet intSet = new IntSet();
        intSet.add(-1);
        intSet.add(0);
        intSet.add(63);
        intSet.add(64);
        intSet.add(127);
        final IntSet other = new IntSet();
        other.add(40);
        other.add(4);
        other.add(44);
        other.add(50);
        other.add(116);
        final IntSet united = intSet.union(other);
        final IntSet intersected = intSet.intersect(other);
        assertTrue(intersected.isSubSet(united));
    }

    @Test
    public void add() throws Exception {
        final IntSet intSet = new IntSet();
        assertFalse(intSet.contains(0));
        intSet.add(0);
        assertTrue(intSet.contains(0));

        assertFalse(intSet.contains(64));
        intSet.add(64);
        assertTrue(intSet.contains(64));

        assertFalse(intSet.contains(128));
        intSet.add(128);
        assertTrue(intSet.contains(128));
    }

    @Test
    public void remove() throws Exception {
        final IntSet intSet = new IntSet();
        assertFalse(intSet.contains(0));
        intSet.add(0);
        assertTrue(intSet.contains(0));
        intSet.remove(0);
        assertFalse(intSet.contains(0));
        assertFalse(intSet.contains(128));
        intSet.add(128);
        assertTrue(intSet.contains(128));
        intSet.remove(128);
        assertFalse(intSet.contains(128));
    }

    @Test
    public void contains() throws Exception {
        final IntSet intSet = new IntSet();


        intSet.add(-1);
        intSet.add(0);
        intSet.add(63);
        intSet.add(64);
        intSet.add(127);

        assertFalse(intSet.contains(13));
        assertFalse(intSet.contains(113));
        assertTrue(intSet.contains(0));
        assertTrue(intSet.contains(63));
        assertTrue(intSet.contains(64));
        assertTrue(intSet.contains(127));
    }

    @Test
    public void union() throws Exception {
        final IntSet intSet = new IntSet();
        intSet.add(-1);
        intSet.add(0);
        intSet.add(63);
        intSet.add(64);
        intSet.add(127);
        final IntSet other = new IntSet();
        other.add(40);
        other.add(4);
        other.add(44);
        other.add(50);
        other.add(116);
        final IntSet united = intSet.union(other);
        assertTrue(united.contains(0));
        assertTrue(united.contains(63));
        assertTrue(united.contains(64));
        assertTrue(united.contains(127));
        assertTrue(united.contains(40));
        assertTrue(united.contains(4));
        assertTrue(united.contains(44));
        assertTrue(united.contains(116));
    }

    @Test
    public void intersect() throws Exception {
        final IntSet intSet = new IntSet();
        intSet.add(-1);
        intSet.add(0);
        intSet.add(63);
        intSet.add(64);
        intSet.add(127);
        final IntSet other = new IntSet();
        other.add(0);
        other.add(63);
        other.add(64);
        other.add(128);
        final IntSet intersected = intSet.intersect(other);
        assertTrue(intersected.contains(0));
        assertTrue(intersected.contains(63));
        assertTrue(intersected.contains(64));
        assertFalse(intersected.contains(127));
        assertFalse(intersected.contains(128));
    }

}