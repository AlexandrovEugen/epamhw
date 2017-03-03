package com.epam.java.se.hw5;


public class IntMark<T extends Integer> extends Mark<Integer> {

    public IntMark(T markValue) {
        super(markValue);
    }

}
