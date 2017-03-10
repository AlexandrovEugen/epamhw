package com.epam.java.se.hw4;

import java.util.Objects;

public class Movie {

    private Actor mainActor;

    private Actor mainActress;
    private String title;
    public Movie(String title) {
        Objects.requireNonNull(title);
        this.title = title;
    }

    public void addActor(Actor actor) {
        Objects.requireNonNull(actor);
        if (actor.getSex().equals(Actor.Sex.male)){
            throw new IllegalArgumentException();
        }
        mainActor = actor;
    }

    public void addActress(Actor actress) {
        if (actress.getSex().equals(Actor.Sex.female)){
            throw new IllegalArgumentException();
        }
        mainActress = actress;
    }

    public Actor getMainActor() {
        return mainActor;
    }

    public Actor getMainActress() {
        return mainActress;
    }

    public String getTitle() {
        return title;
    }
}
