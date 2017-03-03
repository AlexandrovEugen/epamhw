package com.epam.java.se.hw2.tools;

public class PackOfClips {

    private final long cost;
    private boolean usable = true;
    private int amountInThePack;

    public PackOfClips(int amountInThePack, long cost) {
        if (amountInThePack < 0 || cost < 0){
            throw new IllegalArgumentException();
        }
        if (amountInThePack == 0){
            usable = false;
        }
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
