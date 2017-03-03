package com.epam.java.se.hw2.tools;


import java.util.Objects;

public class Cutter {

    private  boolean usable = true;
    private int amountOfBlades;
    private String type;
    private final long cost;

    public Cutter(int amountOfBlades, String type, long cost){
        Objects.requireNonNull(type, "Type of cutter can't be a null");
        if (amountOfBlades < 0 || cost < 0){
            throw new IllegalArgumentException();
        }
        if (amountOfBlades == 0){
            usable = false;
        }
        this.amountOfBlades = amountOfBlades;
        this.type = type;
        this.cost = cost;
    }

    public long getCost() {
        return cost;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public boolean isUsable() {
        return usable;
    }
}
