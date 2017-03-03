package com.epam.java.se.hw5;


import java.util.Objects;

public abstract class Mark<T extends Number> implements Comparable<T>{

    private final T markValue;

    public Mark(T markValue) {
        if (markValue.doubleValue() < 0.0 || markValue.doubleValue() > 5.0){
            throw new IllegalArgumentException();
        }
        this.markValue = markValue;
    }

    public T getMark() {
        return markValue;
    }

    @Override
    public int compareTo(T o) {
        Objects.requireNonNull(o);
        double n1 = this.getMark().doubleValue();
        double n2 = o.doubleValue();
        return Double.compare(n1, n2);
    }
}
