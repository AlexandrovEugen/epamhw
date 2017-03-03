package com.epam.java.se.hw5;


public enum Disciplines {


    Math(false), Philosophy(true), Physics(false), Literature(true), Chemistry(true);

    private final boolean isInt;

    Disciplines(boolean isInt) {

        this.isInt = isInt;
    }

    public boolean isInt() {
        return isInt;
    }
}