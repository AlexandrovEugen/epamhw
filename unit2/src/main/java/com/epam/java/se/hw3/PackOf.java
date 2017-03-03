package com.epam.java.se.hw3;


import java.util.Objects;

public class PackOf extends OfficeTool {

    private int amountOfThingsInThePack;

    enum typeOfThingInThePack {
        plstic, mitalic, special
    }

    public PackOf(long cost, Colour colour, typeOfMaterial type,String nameOfBrand, typeOfThingInThePack typeOfThing, int amountOfThingsInThePack) {
        super(cost, colour, type, nameOfBrand);
        Objects.requireNonNull(typeOfThing);
        if (amountOfThingsInThePack < 0){
            throw new IllegalArgumentException();
        }
        if (amountOfThingsInThePack == 0){
            setUsable(false);
        }
        this.amountOfThingsInThePack = amountOfThingsInThePack;
    }

    public int getAmountOfThingsInThePack() {
        return amountOfThingsInThePack;
    }

    public void setAmountOfThingsInThePack(int amountOfThingsInThePack) {
        this.amountOfThingsInThePack = amountOfThingsInThePack;
    }
}
