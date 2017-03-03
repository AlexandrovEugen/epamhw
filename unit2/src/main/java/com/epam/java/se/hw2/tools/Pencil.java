package com.epam.java.se.hw2.tools;

import java.util.Objects;

public class Pencil {
    private int diameterOfSlatePencil;
    private String type;
    private final long cost;
    private boolean usable = true;

    public Pencil(int diameterOfSlatePencil, String type, long cost) {
        Objects.requireNonNull(type, "Type of pencil can't be a null");
        if (diameterOfSlatePencil <= 0 || cost < 0){
            throw new IllegalArgumentException();
        }
        this.diameterOfSlatePencil = diameterOfSlatePencil;
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
