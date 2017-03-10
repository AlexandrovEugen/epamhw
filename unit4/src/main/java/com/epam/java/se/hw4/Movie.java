package com.epam.java.se.hw4;

import java.io.Serializable;
import java.util.Objects;

public class Movie implements Serializable{

    private Actor mainActor;
    private Actor mainActress;
    private String title;

    public Movie(String title) {
        Objects.requireNonNull(title);
        this.title = title;
    }

    public void addActor(Actor actor) {
        Objects.requireNonNull(actor);
        if (!actor.getSex().equals(Actor.Sex.male)){
            throw new IllegalArgumentException();
        }
        mainActor = actor;
    }

    public void addActress(Actor actress) {
        if (!actress.getSex().equals(Actor.Sex.female)){
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

    @Override
    public int hashCode() {
        int result = mainActor.getSex().hashCode();
        result = 13 * result + mainActor.getName().hashCode();
        result = 13 * result + mainActor.getSureName().hashCode();
        result = 13 * result + mainActress.getSex().hashCode();
        result = 13 * result + mainActress.getName().hashCode();
        result = 13 * result + mainActress.getSureName().hashCode();
        result = 13 * result + title.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        if (mainActor.getSex() != movie.getMainActor().getSex()) return false;
        if (!mainActor.getName().equals(movie.getMainActor().getName())) return false;
        if (!mainActor.getSureName().equals(movie.getMainActor().getSureName())) return false;
        if (mainActress.getSex() != movie.getMainActress().getSex()) return false;
        if (!mainActress.getName().equals(movie.getMainActress().getName())) return false;
        if (!mainActress.getSureName().equals(movie.getMainActress().getSureName())) return false;
        return title.equals(movie.getTitle());
    }

}
