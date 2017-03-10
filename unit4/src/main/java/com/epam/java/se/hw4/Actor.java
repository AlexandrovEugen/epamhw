package com.epam.java.se.hw4;


public class Actor {

    private final String name;

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    private final String sureName;
    private final Sex sex;

    public Sex getSex() {
        return sex;
    }


    enum Sex{

        male,
        female

    }

    public Actor(String name, String sureName, Sex sex) {
        this.name = name;
        this.sureName = sureName;
        this.sex = sex;
    }
}
