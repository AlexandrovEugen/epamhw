package com.epam.java.se.hw2.tools;

import java.util.Objects;

public class PackOfDrawingPins {
    private final String type;
    private final long cost;
    private boolean usable = true;
    private int amountInThePack;

    public PackOfDrawingPins(int amountInThePack, String type, long cost) {
        Objects.requireNonNull(type, "Type of drawing pins can't be a null");
        if (amountInThePack < 0 || cost < 0){
            throw new IllegalArgumentException();
        }
        if (amountInThePack == 0){
            usable = false;
        }
        this.type = type;
        this.cost = cost;
        this.amountInThePack = amountInThePack;
    }

    public boolean isUsable() {
        return usable;
    }

    public long getCost() {
        return cost;
    }
}
