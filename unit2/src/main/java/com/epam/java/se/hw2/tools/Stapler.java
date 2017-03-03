package com.epam.java.se.hw2.tools;


import java.util.Objects;

public class Stapler {
    private String color;
    private final long cost;
    private boolean usable = true;

    public Stapler(String color, long cost) {
        Objects.requireNonNull(color,"Colour cant' be a null");
        if (cost < 0){
            throw  new IllegalArgumentException();
        }
        this.color = color;
        this.cost = cost;
    }

    public long getCost() {
        return cost;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }
}
