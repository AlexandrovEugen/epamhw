package com.epam.java.se.hw3;


import java.util.Objects;

public class Pen  extends WritingTool{

    private final ColourOfInc inc;
    private final TypeOfPen penType;

    public enum ColourOfInc {
        white, black, red, green, blue, yellow, violet, other
    }

    public enum TypeOfPen {
        ballpoint, technical, rollerball, otherType
    }

    public Pen(long cost, Colour colour, typeOfMaterial type, String nameOfBrand, int diameterOfRod, ColourOfInc inc, TypeOfPen penType) {
        super(cost, colour, type,nameOfBrand,diameterOfRod);
        Objects.requireNonNull(inc);
        Objects.requireNonNull(penType);
        this.inc = inc;
        this.penType = penType;
    }
}
