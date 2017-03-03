package com.epam.java.se.hw2.tools;


import java.util.Objects;

public class Pen {
    private int diameterOfRod;
    private String color;
    private String type;
    private final long cost;
    private boolean usable = true;

    public Pen(int diameterOfRod, String color, String type, long cost) {
        Objects.requireNonNull(color, "Colour can't be a null");
        Objects.requireNonNull(type, "type of pen can't be a null");

        if (diameterOfRod <= 0 || cost < 0){
            throw new IllegalArgumentException();
        }

        this.diameterOfRod = diameterOfRod;
        this.color = color;
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
