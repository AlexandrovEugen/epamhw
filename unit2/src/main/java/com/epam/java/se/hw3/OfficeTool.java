package com.epam.java.se.hw3;

import java.util.Objects;

public class OfficeTool {

    private final long cost;
    private boolean usable = true;
    private final Colour colour;
    private final typeOfMaterial type;
    private final String name;

    public String getName() {
        return name;
    }


    public enum typeOfMaterial {
        plastic, metallic, woden, special;
    }

    public enum Colour {
        white, black, red, green, blue, yellow, violet, other
    }
    public OfficeTool(long cost, Colour colour, typeOfMaterial type, String name){
        Objects.requireNonNull(name);
        Objects.requireNonNull(colour,"Colour can't be a null");
        Objects.requireNonNull(type, "Type of material can't be a null");
        if (cost < 0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.cost = cost;
        this.colour = colour;
        this.type = type;
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
