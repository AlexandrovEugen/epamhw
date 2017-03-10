package com.epam.java.se.hw4;


import java.io.Serializable;
import java.util.Objects;

public class Actor implements Serializable {

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
        Objects.requireNonNull(name);
        Objects.requireNonNull(sureName);
        Objects.requireNonNull(sex);
        this.name = name;
        this.sureName = sureName;
        this.sex = sex;
    }
}
