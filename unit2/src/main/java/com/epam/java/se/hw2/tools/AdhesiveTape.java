package com.epam.java.se.hw2.tools;

import java.util.Objects;


public class AdhesiveTape {
    private boolean usable = true;
    private int length;
    private String type;
    private final long cost;

    public AdhesiveTape(int length, String type, long cost) {
        Objects.requireNonNull(type, "Type of Adhesive tape can't be a null");
        if (length < 0 || cost < 0){
            throw new IllegalArgumentException();
        }
        if (length == 0){
            usable = false;
        }
        this.length = length;
        this.type = type;
        this.cost = cost;
    }

    public boolean isUsable() {
        return usable;
    }

    public long getCost() {
        return cost;
    }
}
