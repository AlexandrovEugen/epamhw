package com.epam.java.se.hw3;


public class WritingTool extends OfficeTool {

    private final int diameterOfRod;

    public WritingTool(long cost, Colour colour, typeOfMaterial type, String nameOfBrand, int diameterOfRod) {
        super(cost, colour, type, nameOfBrand);
        if (diameterOfRod <= 0){
            throw new IllegalArgumentException();
        }
        this.diameterOfRod = diameterOfRod;
    }

}
