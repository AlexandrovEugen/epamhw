package com.epam.java.se.hw3;


public class CuttingTool extends OfficeTool {

    private final int amountOfBlades;

    public CuttingTool(long cost, Colour colour, typeOfMaterial type, String nameOfBrand, int amountOfBlades) {
        super(cost, colour, type, nameOfBrand);
        if (amountOfBlades < 0){
            throw new IllegalArgumentException();
        }
        if (amountOfBlades == 0){
            setUsable(false);
        }
        this.amountOfBlades = amountOfBlades;
    }
}
