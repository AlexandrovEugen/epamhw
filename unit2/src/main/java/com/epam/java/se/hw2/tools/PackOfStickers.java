package com.epam.java.se.hw2.tools;


import java.util.Objects;

public class PackOfStickers {
    private boolean usable = true;
    private String color;
    private final long cost;
    private int amountInThePack;

    public PackOfStickers(int amountInThePack, String color, long cost) {
        Objects.requireNonNull(color, "Colour: this argument can't be a null");
        if (amountInThePack < 0 || cost < 0){
            throw new IllegalArgumentException();
        }
        if (amountInThePack == 0){
            usable = false;
        }
        this.color = color;
        this.cost = cost;
        this.amountInThePack = amountInThePack;
    }

    public long getCost() {
        return cost;
    }

    public boolean isUsable() {
        return usable;
    }
}
