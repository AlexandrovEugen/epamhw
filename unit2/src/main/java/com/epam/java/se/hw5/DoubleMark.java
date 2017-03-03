package com.epam.java.se.hw5;


public class DoubleMark<T extends Double> extends Mark<Double> {

    public DoubleMark(T markValue) {
        super(markValue);
    }
}
