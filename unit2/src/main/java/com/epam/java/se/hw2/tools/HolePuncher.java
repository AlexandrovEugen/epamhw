package com.epam.java.se.hw2.tools;

import java.util.Objects;

public class HolePuncher {

    private String type;
    private final long cost;
    private boolean usable = true;

    public HolePuncher(String type, long cost) {
        Objects.requireNonNull(type, "type of hole puncher can't be a null");
        if (cost < 0){
            throw new IllegalArgumentException();
        }
        this.type = type;
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
